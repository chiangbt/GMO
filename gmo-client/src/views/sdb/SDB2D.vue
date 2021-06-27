<template>
  <div style="margin-top:20px;">
    <div id="map"></div>
  </div>
</template>

<script>
import Map from "@arcgis/core/Map";
import MapView from "@arcgis/core/views/MapView";
import FeatureLayer from "@arcgis/core/layers/FeatureLayer";
import GraphicsLayer from '@arcgis/core/layers/GraphicsLayer';
import Home from '@arcgis/core/widgets/Home';
import Bookmarks from '@arcgis/core/widgets/Bookmarks';
import Expand from '@arcgis/core/widgets/Expand';
import Sketch from '@arcgis/core/widgets/Sketch';

export default {
  name: "SDB2D",
  methods: {
    _createMapView () {
      const graphicsLayer = new GraphicsLayer({
        listMode: "hide"
      });
      var map = new Map({
        basemap: 'topo',
        ground: 'world-elevation',
        layers: [graphicsLayer]
      })
      const view = new MapView({
        container: this.$el,
        map: map,
        center: [-118.805, 34.027],
        zoom: 13
      });
      const home = new Home({
        view: view
      })
      view.ui.add(home, "top-left");

      const bookmarks = new Bookmarks({
        view: view,
        editingEnabled: true,
      });
      const bkExpand = new Expand({
        view: view,
        content: bookmarks,
        expanded: false,
      });
      view.ui.add(bkExpand, "top-right");
      
      // 添加sketch
      const sketch = new Sketch({
        view,
        layer: graphicsLayer,
        creationMode: 'continuous',
        snappingOptions: {
          enabled: true,
          featureSources: [{ layer: graphicsLayer }] 
        },
        availableCreateTools: ["point", "polyline", "polygon"],
        visibleElements: {
          createTools: {
            circle: false
          },
          selectionTools:{
            "lasso-selection": false
          },
          settingsMenu: false
        }
      });
      const sketchExpand = new Expand({
        view: view,
        content: sketch,
        expanded: false,
        label: '编辑'
      });
      view.ui.add(sketchExpand, "top-right");

      const popupTrailheads = {
        "title": "Trailhead",
        "content": "<b>Trail:</b> {TRL_NAME}<br><b>City:</b> {CITY_JUR}<br><b>Cross Street:</b> {X_STREET}<br><b>Parking:</b> {PARKING}<br><b>Elevation:</b> {ELEV_FT} ft"
      }
      const trailheads = new FeatureLayer({
        url: "https://services3.arcgis.com/GVgbJbqm8hXASVYi/arcgis/rest/services/Trailheads_Styled/FeatureServer/0",
        outFields: ["TRL_NAME","CITY_JUR","X_STREET","PARKING","ELEV_FT"],
        popupTemplate: popupTrailheads
      });
      map.add(trailheads);

      const trailsLayer = new FeatureLayer({
        url: "https://services3.arcgis.com/GVgbJbqm8hXASVYi/arcgis/rest/services/Trails_Styled/FeatureServer/0"
      });
      map.add(trailsLayer, 0);

      view.when(async () => {
        sketch.on("create", function(event) {
          if (event.state === "complete") {
            const geom = event.graphic.geometry;
            switch (geom.type) {
              case 'point':
                console.log(`point: [${geom.x},${geom.y}]`);
                break;
              case 'polyline':
                console.log(`paths: ${geom.paths}`);
                break;
              case 'polygon':
                console.log(`rings: ${geom.rings}`);
                break;
              default:
                console.log(geom);
            }
          }
        });
      });
    }
  },
  async mounted () {
    this._createMapView()
  }
}
</script>

<style lang="less" scoped>
#map {
  width: 100%;
  height: calc(78vh);
  z-index: 1;
}
/deep/ * {
    outline: none
}
/deep/ .esri-view .esri-view-surface--inset-outline:focus::after {
    outline: auto 0px Highlight !important;
    outline: auto 0px -webkit-focus-ring-color !important;
}
</style>