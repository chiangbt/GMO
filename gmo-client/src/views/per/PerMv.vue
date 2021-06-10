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
import { loadModules } from 'esri-loader'
export default {
  name: "PerMv",
  methods: {
    _createMapView () {
      const option = {
        url: 'https://js.arcgis.com/4.17/dojo/dojo.js',
        css: 'https://js.arcgis.com/4.17/esri/css/main.css'
      }
      loadModules(['esri/Map', 'esri/views/SceneView', 'esri/layers/TileLayer', 'esri/widgets/CoordinateConversion'], option)
        .then(([Map, SceneView, TileLayer, CoordinateConversion]) => {
            var map = new Map({
                basemap: 'hybrid',
                ground: 'world-elevation'
            })
            this.view = new SceneView({
                container: 'map',
                map: map,
                camera: {
                    position: [120.120257, 36.004060, 5184],
                    tilt: 70
                }
            })
            this.view.ui.remove('attribution')
            var ccWidget = new CoordinateConversion({
                view: this.view
            })
            var zjLayer = new TileLayer({
                url: 'https://desktop-chiang.geoportal.cn/arcgis/rest/services/agsdemo/tilemap/MapServer'
            })
            map.layers.add(zjLayer)
            // Adds widget in the bottom left corner of the view
            this.view.ui.add(ccWidget, 'bottom-left')
        }).catch((err) => {
            window.console.log('地图创建失败，' + err)
        })
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