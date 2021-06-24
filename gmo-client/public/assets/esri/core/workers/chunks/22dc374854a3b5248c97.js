self.webpackChunkRemoteClient([55,60],{106:function(e,t,r){"use strict";function a(e){return e&&"esri.renderers.visualVariables.SizeVariable"===e.declaredClass}function i(e){return null!=e&&!isNaN(e)&&isFinite(e)}function n(e){return e.valueExpression?"expression":e.field&&"string"==typeof e.field?"field":"unknown"}function o(e,t){const r=t||n(e),a=e.valueUnit||"unknown";return"unknown"===r?"constant":e.stops?"stops":null!=e.minSize&&null!=e.maxSize&&null!=e.minDataValue&&null!=e.maxDataValue?"clamped-linear":"unknown"===a?null!=e.minSize&&null!=e.minDataValue?e.minSize&&e.minDataValue?"proportional":"additive":"identity":"real-world-size"}r.d(t,"a",(function(){return n})),r.d(t,"b",(function(){return o})),r.d(t,"c",(function(){return a})),r.d(t,"d",(function(){return i}))},155:function(e,t,r){"use strict";r.d(t,"a",(function(){return g})),r.d(t,"b",(function(){return f})),r.d(t,"c",(function(){return m})),r.d(t,"d",(function(){return O})),r.d(t,"e",(function(){return j})),r.d(t,"f",(function(){return v})),r.d(t,"g",(function(){return p}));var a=r(88),i=r(0),n=r(2),o=r(62),s=r(76),l=r(75),c=r(106);const u=n.a.getLogger("esri.renderers.visualVariables.support.visualVariableUtils"),d=new s.a,b=Math.PI,p=/^\s*(return\s+)?\$view\.scale\s*(;)?\s*$/i;function f(e,t,r){const a="visualVariables"in e&&e.visualVariables?e.visualVariables.filter(e=>"color"===e.type)[0]:e;if(!a)return;if("esri.renderers.visualVariables.ColorVariable"!==a.declaredClass)return void u.warn("The visualVariable should be an instance of esri.renderers.visualVariables.ColorVariable");const n="number"==typeof t,s=n?null:t,l=s&&s.attributes;let c=n?t:null;const d=a.field,{ipData:b,hasExpression:p}=a.cache;let f=a.cache.compiledFunc;if(!d&&!p){const e=a.stops;return e&&e[0]&&e[0].color}if("number"!=typeof c)if(p){if(!Object(i.h)(r)||!Object(i.h)(r.arcade))return void u.error("Use of arcade expressions requires an arcade context");const e={viewingMode:r.viewingMode,scale:r.scale,spatialReference:r.spatialReference},t=r.arcade.arcadeUtils,n=t.getViewInfo(e),o=t.createExecContext(s,n);if(!f){const e=t.createSyntaxTree(a.valueExpression);f=t.createFunction(e),a.cache.compiledFunc=f}c=t.executeFunction(f,o)}else l&&(c=l[d]);const m=a.normalizationField,O=l?parseFloat(l[m]):void 0;if(null!=c&&(!m||n||!isNaN(O)&&0!==O)){isNaN(O)||n||(c/=O);const e=w(c,b);if(e){const t=e[0],n=e[1],s=t===n?a.stops[t].color:o.a.blendColors(a.stops[t].color,a.stops[n].color,e[2],Object(i.h)(r)?r.color:void 0);return new o.a(s)}}}function m(e,t,r){const a="visualVariables"in e&&e.visualVariables?e.visualVariables.filter(e=>"opacity"===e.type)[0]:e;if(!a)return;if("esri.renderers.visualVariables.OpacityVariable"!==a.declaredClass)return void u.warn("The visualVariable should be an instance of esri.renderers.visualVariables.OpacityVariable");const n="number"==typeof t,o=n?null:t,s=o&&o.attributes;let l=n?t:null;const c=a.field,{ipData:d,hasExpression:b}=a.cache;let p=a.cache.compiledFunc;if(!c&&!b){const e=a.stops;return e&&e[0]&&e[0].opacity}if("number"!=typeof l)if(b){if(Object(i.g)(r)||Object(i.g)(r.arcade))return void u.error("Use of arcade expressions requires an arcade context");const e={viewingMode:r.viewingMode,scale:r.scale,spatialReference:r.spatialReference},t=r.arcade.arcadeUtils,n=t.getViewInfo(e),s=t.createExecContext(o,n);if(!p){const e=t.createSyntaxTree(a.valueExpression);p=t.createFunction(e),a.cache.compiledFunc=p}l=t.executeFunction(p,s)}else s&&(l=s[c]);const f=a.normalizationField,m=s?parseFloat(s[f]):void 0;if(null!=l&&(!f||n||!isNaN(m)&&0!==m)){isNaN(m)||n||(l/=m);const e=w(l,d);if(e){const t=e[0],r=e[1];if(t===r)return a.stops[t].opacity;{const i=a.stops[t].opacity;return i+(a.stops[r].opacity-i)*e[2]}}}}function O(e,t,r){const a="visualVariables"in e&&e.visualVariables?e.visualVariables.filter(e=>"rotation"===e.type)[0]:e;if(!a)return;if("esri.renderers.visualVariables.RotationVariable"!==a.declaredClass)return void u.warn("The visualVariable should be an instance of esri.renderers.visualVariables.RotationVariable");const n=a.axis||"heading",o="heading"===n&&"arithmetic"===a.rotationType?90:0,s="heading"===n&&"arithmetic"===a.rotationType?-1:1,l="number"==typeof t?null:t,c=l&&l.attributes,d=a.field,{hasExpression:b}=a.cache;let p=a.cache.compiledFunc,f=0;if(!d&&!b)return f;if(b){if(Object(i.g)(r)||Object(i.g)(r.arcade))return void u.error("Use of arcade expressions requires an arcade context");const e={viewingMode:r.viewingMode,scale:r.scale,spatialReference:r.spatialReference},t=r.arcade.arcadeUtils,n=t.getViewInfo(e),o=t.createExecContext(l,n);if(!p){const e=t.createSyntaxTree(a.valueExpression);p=t.createFunction(e),a.cache.compiledFunc=p}f=t.executeFunction(p,o)}else c&&(f=c[d]||0);return f="number"!=typeof f||isNaN(f)?null:o+s*f,f}function j(e,t,r){const a="visualVariables"in e&&e.visualVariables?e.visualVariables.filter(e=>"size"===e.type)[0]:e;if(!a)return;if("esri.renderers.visualVariables.SizeVariable"!==a.declaredClass)return void u.warn("The visualVariable should be an instance of esri.renderers.visualVariables.SizeVariable");const n=function(e,t,r,a,n){switch(t.transformationType){case"additive":return function(e,t,r,a){return e+(h(t.minSize,r,a)||t.minDataValue)}(e,t,r,a);case"constant":return function(e,t,r){const a=e.stops;let i=a&&a.length&&a[0].size;return null==i&&(i=e.minSize),h(i,t,r)}(t,r,a);case"clamped-linear":return function(e,t,r,a){const n=(e-t.minDataValue)/(t.maxDataValue-t.minDataValue),o=h(t.minSize,r,a),s=h(t.maxSize,r,a),l=Object(i.h)(a)?a.shape:void 0;if(e<=t.minDataValue)return o;if(e>=t.maxDataValue)return s;if("area"===t.scaleBy&&l){const e="circle"===l,t=e?b*(o/2)**2:o*o,r=t+n*((e?b*(s/2)**2:s*s)-t);return e?2*Math.sqrt(r/b):Math.sqrt(r)}return o+n*(s-o)}(e,t,r,a);case"proportional":return function(e,t,r,a){const n=Object(i.h)(a)?a.shape:void 0,o=e/t.minDataValue,s=h(t.minSize,r,a),l=h(t.maxSize,r,a);let c=null;return c="circle"===n?2*Math.sqrt(o*(s/2)**2):"square"===n||"diamond"===n||"image"===n?Math.sqrt(o*s**2):o*s,y(c,s,l)}(e,t,r,a);case"stops":return function(e,t,r,a,i){const[n,o,s]=w(e,i);if(n===o)return h(t.stops[n].size,r,a);{const e=h(t.stops[n].size,r,a);return e+(h(t.stops[o].size,r,a)-e)*s}}(e,t,r,a,n);case"real-world-size":return function(e,t,r,a){const n=(Object(i.h)(a)&&a.resolution?a.resolution:1)*l.a[t.valueUnit],o=h(t.minSize,r,a),s=h(t.maxSize,r,a),{valueRepresentation:c}=t;let u=null;return u="area"===c?2*Math.sqrt(e/b)/n:"radius"===c||"distance"===c?2*e/n:e/n,y(u,o,s)}(e,t,r,a);case"identity":return e;case"unknown":return null}}(function(e,t,r){const a="number"==typeof t,n=a?null:t,o=n&&n.attributes;let s=a?t:null;const{isScaleDriven:l}=e.cache;let d=e.cache.compiledFunc;if(l){const t=Object(i.h)(r)?r.scale:void 0,a=Object(i.h)(r)?r.view:void 0;s=null==t||"3d"===a?function(e){let t=null,r=null;const a=e.stops;return a?(t=a[0].value,r=a[a.length-1].value):(t=e.minDataValue||0,r=e.maxDataValue||0),(t+r)/2}(e):t}else if(!a)switch(e.inputValueType){case"expression":{if(Object(i.g)(r)||Object(i.g)(r.arcade))return void u.error("Use of arcade expressions requires an arcade context");const t={viewingMode:r.viewingMode,scale:r.scale,spatialReference:r.spatialReference},a=r.arcade.arcadeUtils,o=a.getViewInfo(t),l=a.createExecContext(n,o);if(!d){const t=a.createSyntaxTree(e.valueExpression);d=a.createFunction(t),e.cache.compiledFunc=d}s=a.executeFunction(d,l);break}case"field":o&&(s=o[e.field]);break;case"unknown":s=null}if(!Object(c.d)(s))return null;if(a||!e.normalizationField)return s;const b=o?parseFloat(o[e.normalizationField]):null;return Object(c.d)(b)&&0!==b?s/b:null}(a,t,r),a,t,r,a.cache.ipData);return null==n||isNaN(n)?0:n}function h(e,t,r){return null==e?null:Object(c.c)(e)?j(e,t,r):Object(c.d)(e)?e:null}function y(e,t,r){return Object(c.d)(r)&&e>r?r:Object(c.d)(t)&&e<t?t:e}function v(e,t,r){const{isScaleDriven:a}=e.cache;if(!(a&&"3d"===r||t))return null;const i={scale:t,view:r};let n=h(e.minSize,d,i),o=h(e.maxSize,d,i);if(null!=n||null!=o){if(n>o){const e=o;o=n,n=e}return{minSize:n,maxSize:o}}}function w(e,t){if(!t)return;let r=0,a=t.length-1;return t.some((t,i)=>e<t?(a=i,!0):(r=i,!1)),[r,a,(e-t[r])/(t[a]-t[r])]}function g(e,t,r){const i=["proportional","proportional","proportional"];for(const n of e){const e=n.useSymbolValue?"symbol-value":j(n,t,r);switch(n.axis){case"width":i[0]=e;break;case"depth":i[1]=e;break;case"height":i[2]=e;break;case"width-and-depth":i[0]=e,i[1]=e;break;case"all":case void 0:case null:i[0]=e,i[1]=e,i[2]=e;break;default:Object(a.a)(n.axis)}}return i}},156:function(e,t,r){"use strict";var a=r(13),i=(r(3),r(6)),n=(r(2),r(5),r(15)),o=r(59),s=r(18),l=r(56),c=(r(21),r(36),r(37),r(55));const u=new o.a({esriFeatureEditToolAutoCompletePolygon:"auto-complete-polygon",esriFeatureEditToolCircle:"circle",esriFeatureEditToolEllipse:"ellipse",esriFeatureEditToolFreehand:"freehand",esriFeatureEditToolLine:"line",esriFeatureEditToolNone:"none",esriFeatureEditToolPoint:"point",esriFeatureEditToolPolygon:"polygon",esriFeatureEditToolRectangle:"rectangle",esriFeatureEditToolArrow:"arrow",esriFeatureEditToolTriangle:"triangle",esriFeatureEditToolLeftArrow:"left-arrow",esriFeatureEditToolRightArrow:"right-arrow",esriFeatureEditToolUpArrow:"up-arrow",esriFeatureEditToolDownArrow:"down-arrow"});let d=class extends c.a{constructor(e){super(e),this.name=null,this.description=null,this.drawingTool=null,this.prototype=null,this.thumbnail=null}writeDrawingTool(e,t){t.drawingTool=u.toJSON(e)}writePrototype(e,t){t.prototype=Object(i.c)(Object(i.a)(e),!0)}writeThumbnail(e,t){t.thumbnail=Object(i.c)(Object(i.a)(e))}};Object(a.a)([Object(n.b)({json:{write:!0}})],d.prototype,"name",void 0),Object(a.a)([Object(n.b)({json:{write:!0}})],d.prototype,"description",void 0),Object(a.a)([Object(n.b)({json:{read:u.read,write:u.write}})],d.prototype,"drawingTool",void 0),Object(a.a)([Object(l.a)("drawingTool")],d.prototype,"writeDrawingTool",null),Object(a.a)([Object(n.b)({json:{write:!0}})],d.prototype,"prototype",void 0),Object(a.a)([Object(l.a)("prototype")],d.prototype,"writePrototype",null),Object(a.a)([Object(n.b)({json:{write:!0}})],d.prototype,"thumbnail",void 0),Object(a.a)([Object(l.a)("thumbnail")],d.prototype,"writeThumbnail",null),d=Object(a.a)([Object(s.a)("esri.layers.support.FeatureTemplate")],d);var b=d;t.a=b},205:function(e,t,r){"use strict";r.d(t,"a",(function(){return o}));var a=r(13),i=(r(3),r(2),r(5),r(15)),n=r(18);r(21),r(36),r(37);const o=e=>{let t=class extends e{constructor(){super(...arguments),this.customParameters=null}};return Object(a.a)([Object(i.b)({json:{write:!0,origins:{"web-scene":{write:!1}}}})],t.prototype,"customParameters",void 0),t=Object(a.a)([Object(n.a)("esri.layers.mixins.CustomParametersMixin")],t),t}},206:function(e,t,r){"use strict";var a=r(13),i=(r(3),r(6)),n=(r(2),r(5),r(15)),o=r(57),s=r(18),l=r(56),c=(r(21),r(36),r(37),r(55)),u=r(132),d=r(128),b=r(129),p=(r(148),r(156));let f=class extends c.a{constructor(e){super(e),this.id=null,this.name=null,this.domains=null,this.templates=null}readDomains(e){const t={};for(const r in e)if(e.hasOwnProperty(r)){const a=e[r];switch(a.type){case"range":t[r]=b.a.fromJSON(a);break;case"codedValue":t[r]=u.a.fromJSON(a);break;case"inherited":t[r]=d.a.fromJSON(a)}}return t}writeDomains(e,t){const r={};for(const t in e)e.hasOwnProperty(t)&&(r[t]=e[t]&&e[t].toJSON());Object(i.c)(r),t.domains=r}readTemplates(e){return e&&e.map(e=>new p.a(e))}writeTemplates(e,t){t.templates=e&&e.map(e=>e.toJSON())}};Object(a.a)([Object(n.b)({json:{write:!0}})],f.prototype,"id",void 0),Object(a.a)([Object(n.b)({json:{write:!0}})],f.prototype,"name",void 0),Object(a.a)([Object(n.b)({json:{write:!0}})],f.prototype,"domains",void 0),Object(a.a)([Object(o.a)("domains")],f.prototype,"readDomains",null),Object(a.a)([Object(l.a)("domains")],f.prototype,"writeDomains",null),Object(a.a)([Object(n.b)({json:{write:!0}})],f.prototype,"templates",void 0),Object(a.a)([Object(o.a)("templates")],f.prototype,"readTemplates",null),Object(a.a)([Object(l.a)("templates")],f.prototype,"writeTemplates",null),f=Object(a.a)([Object(s.a)("esri.layers.support.FeatureType")],f);var m=f;t.a=m},398:function(e,t,r){"use strict";r.r(t);var a=r(13),i=(r(3),r(2),r(5),r(15)),n=r(57),o=r(18),s=(r(21),r(36),r(37),r(69)),l=r(87),c=r(84),u=r(99),d=r(96),b=r(167);let p=class extends(Object(u.a)(Object(d.a)(Object(c.a)(l.a)))){constructor(...e){super(...e),this.type="route"}get barrierLines(){return this._getNamedFeatureLayer("PolylineBarriers")}get barrierPoints(){return this._getNamedFeatureLayer("Barriers")}get barrierPolygons(){return this._getNamedFeatureLayer("PolygonBarriers")}get directionLines(){return this._getNamedFeatureLayer("DirectionLines")}get directionPoints(){return this._getNamedFeatureLayer("DirectionPoints")}readFeatureCollectionsFromItem(e,t,r){return this.revert("featureCollections","portal-item"),t.layers.map(e=>{const t=new b.default;return t.read(e,r),t})}readFeatureCollectionsFromWebMap(e,t,r){return t.featureCollection.layers.map(e=>{const t=new b.default;return t.read(e,r),t})}get fullExtent(){return this.featureCollections?this.featureCollections.reduce((e,t)=>e?e.union(t.fullExtent):t.fullExtent,null):null}get maxScale(){return this.featureCollections?this.featureCollections.reduce((e,t)=>null==e?t.maxScale:Math.min(e,t.maxScale),null):0}set maxScale(e){this.featureCollections.forEach(t=>{t.maxScale=e}),this._set("maxScale",e)}get minScale(){return this.featureCollections?this.featureCollections.reduce((e,t)=>null==e?t.minScale:Math.min(e,t.minScale),null):0}set minScale(e){this.featureCollections.forEach(t=>{t.minScale=e}),this._set("minScale",e)}get routeInfo(){return this._getNamedFeatureLayer("RouteInfo")}get stops(){return this._getNamedFeatureLayer("Stops")}load(e){return this.addResolvingPromise(this.loadFromPortal({supportedTypes:["Feature Collection"]},e)),Promise.resolve(this)}_getNamedFeatureLayer(e){if(this.featureCollections)return this.featureCollections.find(t=>t.title===e)}};Object(a.a)([Object(i.b)()],p.prototype,"barrierLines",null),Object(a.a)([Object(i.b)()],p.prototype,"barrierPoints",null),Object(a.a)([Object(i.b)()],p.prototype,"barrierPolygons",null),Object(a.a)([Object(i.b)()],p.prototype,"directionLines",null),Object(a.a)([Object(i.b)()],p.prototype,"directionPoints",null),Object(a.a)([Object(i.b)({type:s.a.ofType(b.default)})],p.prototype,"featureCollections",void 0),Object(a.a)([Object(n.a)("portal-item","featureCollections",["layers"])],p.prototype,"readFeatureCollectionsFromItem",null),Object(a.a)([Object(n.a)("web-map","featureCollections",["featureCollection.layers"])],p.prototype,"readFeatureCollectionsFromWebMap",null),Object(a.a)([Object(i.b)({readOnly:!0})],p.prototype,"fullExtent",null),Object(a.a)([Object(i.b)({type:["show","hide"]})],p.prototype,"listMode",void 0),Object(a.a)([Object(i.b)()],p.prototype,"maxScale",null),Object(a.a)([Object(i.b)()],p.prototype,"minScale",null),Object(a.a)([Object(i.b)()],p.prototype,"routeInfo",null),Object(a.a)([Object(i.b)()],p.prototype,"stops",null),Object(a.a)([Object(i.b)({readOnly:!0,json:{read:!1}})],p.prototype,"type",void 0),p=Object(a.a)([Object(o.a)("esri.layers.RouteLayer")],p);var f=p;t.default=f},75:function(e,t,r){"use strict";r.d(t,"a",(function(){return n}));var a=r(100),i=r(72);const n={inches:Object(i.b)(1,"meters","inches"),feet:Object(i.b)(1,"meters","feet"),"us-feet":Object(i.b)(1,"meters","us-feet"),yards:Object(i.b)(1,"meters","yards"),miles:Object(i.b)(1,"meters","miles"),"nautical-miles":Object(i.b)(1,"meters","nautical-miles"),millimeters:Object(i.b)(1,"meters","millimeters"),centimeters:Object(i.b)(1,"meters","centimeters"),decimeters:Object(i.b)(1,"meters","decimeters"),meters:Object(i.b)(1,"meters","meters"),kilometers:Object(i.b)(1,"meters","kilometers"),"decimal-degrees":1/Object(i.h)(1,"meters",a.a.radius)}},88:function(e,t,r){"use strict";r.d(t,"a",(function(){return a}));r(3);function a(e){}}});