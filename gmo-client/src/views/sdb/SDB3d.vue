<template>
  <a-row :gutter="16">
    <a-col :span="24">
      <a-card :bordered="false">
        <div id="map"></div>
      </a-card>
    </a-col>
  </a-row>
</template>

<script>
import Map from "@arcgis/core/Map";
import SceneView from "@arcgis/core/views/SceneView";
import TileLayer from "@arcgis/core/layers/TileLayer";
import Bookmarks from "@arcgis/core/widgets/Bookmarks";
import Expand from "@arcgis/core/widgets/Expand";

export default {
  name: "SDB3d",
  methods: {
    _createMapView () {
      var map = new Map({
        basemap: 'hybrid',
        ground: 'world-elevation'
      })
      const view =new SceneView({
          container: 'map',
          map: map,
          camera: {
              position: [120.120257, 36.004060, 5184],
              tilt: 70
          }
      });
      const bookmarks = new Bookmarks({
        view: view,
        // allows bookmarks to be added, edited, or deleted
        editingEnabled: true,
      });
      const bkExpand = new Expand({
        view: view,
        content: bookmarks,
        expanded: false,
      });
      // Add the widget to the top-right corner of the view
      view.ui.add(bkExpand, "top-right");
      var zjLayer = new TileLayer({
        url: 'https://desktop-chiang.geoportal.cn/arcgis/rest/services/agsdemo/tilemap/MapServer'
      })
      map.layers.add(zjLayer)
    }
  },
  mounted () {
    this._createMapView()
  }
}
</script>

<style lang="less" scoped>
#map {
  width: 100%;
  height: calc(80vh);
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