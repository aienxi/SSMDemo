(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d5b373bc"],{4649:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"base-view"},[i("div",{style:"width:"+t.contentWidth},[i("el-form",{staticClass:"head-form-inline",attrs:{inline:!0,model:t.searchCondition}},[i("el-form-item",{attrs:{label:"检索"}},[i("el-input",{staticClass:"input-w",attrs:{placeholder:"检索",clearable:""},model:{value:t.searchCondition.docName,callback:function(e){t.$set(t.searchCondition,"docName",e)},expression:"searchCondition.docName"}})],1),t._v(" "),i("el-form-item",[i("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:function(e){return t.reqDocList()}}},[t._v("搜索")])],1),t._v(" "),i("el-button",{staticClass:"up-button",attrs:{type:"primary",icon:"el-icon-upload"},on:{click:t.clickUploadButton}},[t._v("添加")])],1),t._v(" "),t._l(t.arrData,(function(e,n){return i("div",{key:n,staticClass:"row-view"},[i("el-card",{attrs:{shadow:"hover"}},[i("div",{on:{click:function(i){return i.preventDefault(),t.gotoDetail(e)}}},[i("span",{staticClass:"row-title"},[t._v(t._s(e.docName))]),t._v(" "),i("el-divider",{staticClass:"divider"}),t._v(" "),i("div",{staticClass:"content-desc"},[t._v("\n            "+t._s(e.docSummary)+"\n          ")]),t._v(" "),i("div",{staticClass:"bottom-base"},[i("div",{staticClass:"info-base"},[i("div",{staticClass:"publish-view"},[t._v("发布者："+t._s(e.salesName))]),t._v(" "),i("div",{staticClass:"time-view"},[t._v("更新日期："+t._s(e.updateTime.length?e.updateTime:e.createTime))])]),t._v(" "),i("div",{staticClass:"button-base"},[i("el-button-group",[i("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-download"},on:{click:function(i){return i.stopPropagation(),t.downloadDoc(e)}}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-chat-line-round"},on:{click:function(i){return i.preventDefault(),t.gotoDetail(e,"comment")}}},[t._v("评论")])],1)],1)])],1)])],1)})),t._v(" "),i("el-dialog",{attrs:{width:"600px",title:"文件上传",visible:t.showUpload,"close-on-click-modal":!1,center:""},on:{"update:visible":function(e){t.showUpload=e}}},[i("doc-upload",{attrs:{"class-id":t.classId,action:1},on:{upSucceed:t.upSucceed}})],1)],2)])},o=[],s=(i("e680"),i("3dec")),a=i("424e"),c={name:"DocContent",components:{DocUpload:s["a"]},props:{classId:{type:Number,required:!0}},data:function(){return{searchCondition:{docName:"",pageNum:1},currentChange:1,arrData:[],showUpload:!1,fullWidth:document.documentElement.clientWidth,contentWidth:""}},computed:{},created:function(){this.searchCondition.classId=this.classId,this.reqDocList(this.classId),window.addEventListener("resize",this.handleResize),this.setContentWidth()},methods:{reqDocList:function(){var t=this;Object(a["d"])(this.searchCondition).then((function(e){1===e.code?t.arrData=e.data:t.$msg.error(e.msg)})).catch((function(t){}))},gotoDetail:function(t,e){this.$router.push({name:"DocDetail",query:{classId:this.classId,action:e,info:t}})},upSucceed:function(t){this.reqDocList(),this.showUpload=!1},downloadDoc:function(t){window.location.href=t.docUrl},clickUploadButton:function(){this.showUpload=!0},clearnSearch:function(){this.searchCondition={pageNum:1},this.reqCustomList()},handleResize:function(t){this.fullWidth=document.documentElement.clientWidth,this.setContentWidth()},setContentWidth:function(){this.fullWidth<=800?this.contentWidth=this.fullWidth-40+"px":this.contentWidth="760px"},beforeDestroy:function(){window.removeEventListener("resize",this.handleResize)}}},l=c,d=(i("4b0a"),i("c701")),r=Object(d["a"])(l,n,o,!1,null,"5888719c",null);e["a"]=r.exports},"4b0a":function(t,e,i){"use strict";i("a761")},a761:function(t,e,i){},d6f5:function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"content-view"},[i("doc-content",{attrs:{"class-id":t.classId}})],1)},o=[],s=i("4649"),a={name:"ContractDoc",components:{DocContent:s["a"]},data:function(){return{classId:0}},created:function(){this.classId=this.$route.meta.classId}},c=a,l=i("c701"),d=Object(l["a"])(c,n,o,!1,null,"7e03edae",null);e["default"]=d.exports}}]);