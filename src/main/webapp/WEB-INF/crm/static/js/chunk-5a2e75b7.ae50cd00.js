(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a2e75b7"],{2441:function(e,t,n){},"323b":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("article-detail",{attrs:{"is-edit":!1}})},a=[],o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"createPost-container"},[n("el-form",{ref:"postForm",staticClass:"form-container",attrs:{model:e.postForm,rules:e.rules}},[n("sticky",{attrs:{"z-index":10,"class-name":"sub-navbar "+e.postForm.status}},[n("CommentDropdown",{model:{value:e.postForm.comment_disabled,callback:function(t){e.$set(e.postForm,"comment_disabled",t)},expression:"postForm.comment_disabled"}}),e._v(" "),n("PlatformDropdown",{model:{value:e.postForm.platforms,callback:function(t){e.$set(e.postForm,"platforms",t)},expression:"postForm.platforms"}}),e._v(" "),n("SourceUrlDropdown",{model:{value:e.postForm.source_uri,callback:function(t){e.$set(e.postForm,"source_uri",t)},expression:"postForm.source_uri"}}),e._v(" "),n("el-button",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{"margin-left":"10px"},attrs:{type:"success"},on:{click:e.submitForm}},[e._v("\n        Publish\n      ")]),e._v(" "),n("el-button",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{type:"warning"},on:{click:e.draftForm}},[e._v("\n        Draft\n      ")])],1),e._v(" "),n("div",{staticClass:"createPost-main-container"},[n("el-row",[n("Warning"),e._v(" "),n("el-col",{attrs:{span:24}},[n("el-form-item",{staticStyle:{"margin-bottom":"40px"},attrs:{prop:"title"}},[n("MDinput",{attrs:{maxlength:100,name:"name",required:""},model:{value:e.postForm.title,callback:function(t){e.$set(e.postForm,"title",t)},expression:"postForm.title"}},[e._v("\n              Title\n            ")])],1),e._v(" "),n("div",{staticClass:"postInfo-container"},[n("el-row",[n("el-col",{attrs:{span:8}},[n("el-form-item",{staticClass:"postInfo-container-item",attrs:{"label-width":"60px",label:"Author:"}},[n("el-select",{attrs:{"remote-method":e.getRemoteUserList,filterable:"","default-first-option":"",remote:"",placeholder:"Search user"},model:{value:e.postForm.author,callback:function(t){e.$set(e.postForm,"author",t)},expression:"postForm.author"}},e._l(e.userListOptions,(function(e,t){return n("el-option",{key:e+t,attrs:{label:e,value:e}})})),1)],1)],1),e._v(" "),n("el-col",{attrs:{span:10}},[n("el-form-item",{staticClass:"postInfo-container-item",attrs:{"label-width":"120px",label:"Publish Time:"}},[n("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss",placeholder:"Select date and time"},model:{value:e.displayTime,callback:function(t){e.displayTime=t},expression:"displayTime"}})],1)],1),e._v(" "),n("el-col",{attrs:{span:6}},[n("el-form-item",{staticClass:"postInfo-container-item",attrs:{"label-width":"90px",label:"Importance:"}},[n("el-rate",{staticStyle:{display:"inline-block"},attrs:{max:3,colors:["#99A9BF","#F7BA2A","#FF9900"],"low-threshold":1,"high-threshold":3},model:{value:e.postForm.importance,callback:function(t){e.$set(e.postForm,"importance",t)},expression:"postForm.importance"}})],1)],1)],1)],1)],1)],1),e._v(" "),n("el-form-item",{staticStyle:{"margin-bottom":"40px"},attrs:{"label-width":"70px",label:"Summary:"}},[n("el-input",{staticClass:"article-textarea",attrs:{rows:1,type:"textarea",autosize:"",placeholder:"Please enter the content"},model:{value:e.postForm.content_short,callback:function(t){e.$set(e.postForm,"content_short",t)},expression:"postForm.content_short"}}),e._v(" "),n("span",{directives:[{name:"show",rawName:"v-show",value:e.contentShortLength,expression:"contentShortLength"}],staticClass:"word-counter"},[e._v(e._s(e.contentShortLength)+"words")])],1),e._v(" "),n("el-form-item",{staticStyle:{"margin-bottom":"30px"},attrs:{prop:"content"}},[n("Tinymce",{ref:"editor",attrs:{height:400},model:{value:e.postForm.content,callback:function(t){e.$set(e.postForm,"content",t)},expression:"postForm.content"}})],1),e._v(" "),n("el-form-item",{staticStyle:{"margin-bottom":"30px"},attrs:{prop:"image_uri"}},[n("Upload",{model:{value:e.postForm.image_uri,callback:function(t){e.$set(e.postForm,"image_uri",t)},expression:"postForm.image_uri"}})],1)],1)],1)],1)},r=[],l=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"tinymce-container",class:{fullscreen:e.fullscreen},style:{width:e.containerWidth}},[n("textarea",{staticClass:"tinymce-textarea",attrs:{id:e.tinymceId}}),e._v(" "),n("div",{staticClass:"editor-custom-btn-container"},[n("editorImage",{staticClass:"editor-upload-btn",attrs:{color:"#1890ff"},on:{successCBK:e.imageSuccessCBK}})],1)])},s=[],c=(n("1bc7"),n("e680"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"upload-container"},[n("el-button",{style:{background:e.color,borderColor:e.color},attrs:{icon:"el-icon-upload",size:"mini",type:"primary"},on:{click:function(t){e.dialogVisible=!0}}},[e._v("\n    upload\n  ")]),e._v(" "),n("el-dialog",{attrs:{visible:e.dialogVisible},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("el-upload",{staticClass:"editor-slide-upload",attrs:{multiple:!0,"file-list":e.fileList,"show-file-list":!0,"on-remove":e.handleRemove,"on-success":e.handleSuccess,"before-upload":e.beforeUpload,action:"https://httpbin.org/post","list-type":"picture-card"}},[n("el-button",{attrs:{size:"small",type:"primary"}},[e._v("\n        Click upload\n      ")])],1),e._v(" "),n("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("\n      Cancel\n    ")]),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:e.handleSubmit}},[e._v("\n      Confirm\n    ")])],1)],1)}),u=[],d=(n("32ea"),{name:"EditorSlideUpload",props:{color:{type:String,default:"#1890ff"}},data:function(){return{dialogVisible:!1,listObj:{},fileList:[]}},methods:{checkAllSuccess:function(){var e=this;return Object.keys(this.listObj).every((function(t){return e.listObj[t].hasSuccess}))},handleSubmit:function(){var e=this,t=Object.keys(this.listObj).map((function(t){return e.listObj[t]}));this.checkAllSuccess()?(this.$emit("successCBK",t),this.listObj={},this.fileList=[],this.dialogVisible=!1):this.$message("Please wait for all images to be uploaded successfully. If there is a network problem, please refresh the page and upload again!")},handleSuccess:function(e,t){for(var n=t.uid,i=Object.keys(this.listObj),a=0,o=i.length;a<o;a++)if(this.listObj[i[a]].uid===n)return this.listObj[i[a]].url=e.files.file,void(this.listObj[i[a]].hasSuccess=!0)},handleRemove:function(e){for(var t=e.uid,n=Object.keys(this.listObj),i=0,a=n.length;i<a;i++)if(this.listObj[n[i]].uid===t)return void delete this.listObj[n[i]]},beforeUpload:function(e){var t=this,n=window.URL||window.webkitURL,i=e.uid;return this.listObj[i]={},new Promise((function(a,o){var r=new Image;r.src=n.createObjectURL(e),r.onload=function(){t.listObj[i]={hasSuccess:!1,uid:e.uid,width:this.width,height:this.height}},a(!0)}))}}}),m=d,p=(n("5278"),n("c701")),h=Object(p["a"])(m,c,u,!1,null,"3dae379b",null),f=h.exports,v=["advlist anchor autolink autosave code codesample colorpicker colorpicker contextmenu directionality emoticons fullscreen hr image imagetools insertdatetime link lists media nonbreaking noneditable pagebreak paste preview print save searchreplace spellchecker tabfocus table template textcolor textpattern visualblocks visualchars wordcount"],g=v,b=["searchreplace bold italic underline strikethrough alignleft aligncenter alignright outdent indent  blockquote undo redo removeformat subscript superscript code codesample","hr bullist numlist link image charmap preview anchor pagebreak insertdatetime media table emoticons forecolor backcolor fullscreen"],y=b;n("9f60"),n("94f0"),n("0c84"),n("2843"),n("a450"),n("4057");function _(e,t){var n;if("undefined"===typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(n=w(e))||t&&e&&"number"===typeof e.length){n&&(e=n);var i=0,a=function(){};return{s:a,n:function(){return i>=e.length?{done:!0}:{done:!1,value:e[i++]}},e:function(e){throw e},f:a}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var o,r=!0,l=!1;return{s:function(){n=e[Symbol.iterator]()},n:function(){var e=n.next();return r=e.done,e},e:function(e){l=!0,o=e},f:function(){try{r||null==n.return||n.return()}finally{if(l)throw o}}}}function w(e,t){if(e){if("string"===typeof e)return x(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);return"Object"===n&&e.constructor&&(n=e.constructor.name),"Map"===n||"Set"===n?Array.from(e):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?x(e,t):void 0}}function x(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,i=new Array(t);n<t;n++)i[n]=e[n];return i}var C=[];function k(){return window.tinymce}var S=function(e,t){var n=document.getElementById(e),i=t||function(){};if(!n){var a=document.createElement("script");a.src=e,a.id=e,document.body.appendChild(a),C.push(i);var o="onload"in a?r:l;o(a)}function r(t){t.onload=function(){this.onerror=this.onload=null;var e,n=_(C);try{for(n.s();!(e=n.n()).done;){var i=e.value;i(null,t)}}catch(a){n.e(a)}finally{n.f()}C=null},t.onerror=function(){this.onerror=this.onload=null,i(new Error("Failed to load "+e),t)}}function l(e){e.onreadystatechange=function(){if("complete"===this.readyState||"loaded"===this.readyState){this.onreadystatechange=null;var t,n=_(C);try{for(n.s();!(t=n.n()).done;){var i=t.value;i(null,e)}}catch(a){n.e(a)}finally{n.f()}C=null}}}n&&i&&(k()?i(null,n):C.push(i))},F=S,I="https://cdn.jsdelivr.net/npm/tinymce-all-in-one@4.9.3/tinymce.min.js",$={name:"Tinymce",components:{editorImage:f},props:{id:{type:String,default:function(){return"vue-tinymce-"+ +new Date+(1e3*Math.random()).toFixed(0)}},value:{type:String,default:""},toolbar:{type:Array,required:!1,default:function(){return[]}},menubar:{type:String,default:"file edit insert view format table"},height:{type:[Number,String],required:!1,default:360},width:{type:[Number,String],required:!1,default:"auto"}},data:function(){return{hasChange:!1,hasInit:!1,tinymceId:this.id,fullscreen:!1,languageTypeList:{en:"en",zh:"zh_CN",es:"es_MX",ja:"ja"}}},computed:{containerWidth:function(){var e=this.width;return/^[\d]+(\.[\d]+)?$/.test(e)?"".concat(e,"px"):e}},watch:{value:function(e){var t=this;!this.hasChange&&this.hasInit&&this.$nextTick((function(){return window.tinymce.get(t.tinymceId).setContent(e||"")}))}},mounted:function(){this.init()},activated:function(){window.tinymce&&this.initTinymce()},deactivated:function(){this.destroyTinymce()},destroyed:function(){this.destroyTinymce()},methods:{init:function(){var e=this;F(I,(function(t){t?e.$message.error(t.message):e.initTinymce()}))},initTinymce:function(){var e=this,t=this;window.tinymce.init({selector:"#".concat(this.tinymceId),language:this.languageTypeList["en"],height:this.height,body_class:"panel-body ",object_resizing:!1,toolbar:this.toolbar.length>0?this.toolbar:y,menubar:this.menubar,plugins:g,end_container_on_empty_block:!0,powerpaste_word_import:"clean",code_dialog_height:450,code_dialog_width:1e3,advlist_bullet_styles:"square",advlist_number_styles:"default",imagetools_cors_hosts:["www.tinymce.com","codepen.io"],default_link_target:"_blank",link_title:!1,nonbreaking_force_tab:!0,init_instance_callback:function(n){t.value&&n.setContent(t.value),t.hasInit=!0,n.on("NodeChange Change KeyUp SetContent",(function(){e.hasChange=!0,e.$emit("input",n.getContent())}))},setup:function(e){e.on("FullscreenStateChanged",(function(e){t.fullscreen=e.state}))},convert_urls:!1})},destroyTinymce:function(){var e=window.tinymce.get(this.tinymceId);this.fullscreen&&e.execCommand("mceFullScreen"),e&&e.destroy()},setContent:function(e){window.tinymce.get(this.tinymceId).setContent(e)},getContent:function(){window.tinymce.get(this.tinymceId).getContent()},imageSuccessCBK:function(e){var t=this;e.forEach((function(e){window.tinymce.get(t.tinymceId).insertContent('<img class="wscnph" src="'.concat(e.url,'" >'))}))}}},O=$,j=(n("a35d"),Object(p["a"])(O,l,s,!1,null,"53cd37d0",null)),E=j.exports,N=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"upload-container"},[n("el-upload",{staticClass:"image-uploader",attrs:{data:e.dataObj,multiple:!1,"show-file-list":!1,"on-success":e.handleImageSuccess,drag:"",action:"https://httpbin.org/post"}},[n("i",{staticClass:"el-icon-upload"}),e._v(" "),n("div",{staticClass:"el-upload__text"},[e._v("\n      将文件拖到此处，或"),n("em",[e._v("点击上传")])])]),e._v(" "),n("div",{staticClass:"image-preview image-app-preview"},[n("div",{directives:[{name:"show",rawName:"v-show",value:e.imageUrl.length>1,expression:"imageUrl.length>1"}],staticClass:"image-preview-wrapper"},[n("img",{attrs:{src:e.imageUrl}}),e._v(" "),n("div",{staticClass:"image-preview-action"},[n("i",{staticClass:"el-icon-delete",on:{click:e.rmImage}})])])]),e._v(" "),n("div",{staticClass:"image-preview"},[n("div",{directives:[{name:"show",rawName:"v-show",value:e.imageUrl.length>1,expression:"imageUrl.length>1"}],staticClass:"image-preview-wrapper"},[n("img",{attrs:{src:e.imageUrl}}),e._v(" "),n("div",{staticClass:"image-preview-action"},[n("i",{staticClass:"el-icon-delete",on:{click:e.rmImage}})])])])],1)},V=[],M={name:"SingleImageUpload3",props:{value:{type:String,default:""}},data:function(){return{tempUrl:"",dataObj:{token:"",key:""}}},computed:{imageUrl:function(){return this.value}},methods:{rmImage:function(){this.emitInput("")},emitInput:function(e){this.$emit("input",e)},handleImageSuccess:function(e){this.emitInput(e.files.file)}}},T=M,A=(n("66f5"),Object(p["a"])(T,N,V,!1,null,"ca403bcc",null)),P=A.exports,U=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"material-input__component",class:e.computedClasses},[n("div",{class:{iconClass:e.icon}},[e.icon?n("i",{staticClass:"el-input__icon material-input__icon",class:["el-icon-"+e.icon]}):e._e(),e._v(" "),"email"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"email"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"url"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"url"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"number"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,step:e.step,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,max:e.max,min:e.min,minlength:e.minlength,maxlength:e.maxlength,required:e.required,type:"number"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"password"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,max:e.max,min:e.min,required:e.required,type:"password"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"tel"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"tel"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"text"===e.type?n("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,minlength:e.minlength,maxlength:e.maxlength,required:e.required,type:"text"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),n("span",{staticClass:"material-input-bar"}),e._v(" "),n("label",{staticClass:"material-label"},[e._t("default")],2)])])},B=[],L={name:"MdInput",props:{icon:String,name:String,type:{type:String,default:"text"},value:[String,Number],placeholder:String,readonly:Boolean,disabled:Boolean,min:String,max:String,step:String,minlength:Number,maxlength:Number,required:{type:Boolean,default:!0},autoComplete:{type:String,default:"off"},validateEvent:{type:Boolean,default:!0}},data:function(){return{currentValue:this.value,focus:!1,fillPlaceHolder:null}},computed:{computedClasses:function(){return{"material--active":this.focus,"material--disabled":this.disabled,"material--raised":Boolean(this.focus||this.currentValue)}}},watch:{value:function(e){this.currentValue=e}},methods:{handleModelInput:function(e){var t=e.target.value;this.$emit("input",t),"ElFormItem"===this.$parent.$options.componentName&&this.validateEvent&&this.$parent.$emit("el.form.change",[t]),this.$emit("change",t)},handleMdFocus:function(e){this.focus=!0,this.$emit("focus",e),this.placeholder&&""!==this.placeholder&&(this.fillPlaceHolder=this.placeholder)},handleMdBlur:function(e){this.focus=!1,this.$emit("blur",e),this.fillPlaceHolder=null,"ElFormItem"===this.$parent.$options.componentName&&this.validateEvent&&this.$parent.$emit("el.form.blur",[this.currentValue])}}},R=L,q=(n("49b7"),Object(p["a"])(R,U,B,!1,null,"9d7baaf6",null)),z=q.exports,D=n("b804"),H=n("61f7"),K=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},W=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("aside",[e._v("\n  Creating and editing pages cannot be cached by keep-alive because keep-alive include does not currently support\n  caching based on routes, so it is currently cached based on component name. If you want to achieve a similar caching\n  effect, you can use a browser caching scheme such as localStorage. Or do not use keep-alive include to cache all\n  pages directly. See details\n  "),n("a",{attrs:{href:"https://panjiachen.github.io/vue-element-admin-site/guide/essentials/tags-view.html",target:"_blank"}},[e._v("Document")])])}],G={},X=Object(p["a"])(G,K,W,!1,null,null,null),J=X.exports,Y=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dropdown",{attrs:{"show-timeout":100,trigger:"click"}},[n("el-button",{attrs:{plain:""}},[e._v("\n    "+e._s(e.comment_disabled?"Comment: closed":"Comment: opened")+"\n    "),n("i",{staticClass:"el-icon-caret-bottom el-icon--right"})]),e._v(" "),n("el-dropdown-menu",{staticClass:"no-padding",attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[n("el-radio-group",{staticStyle:{padding:"10px"},model:{value:e.comment_disabled,callback:function(t){e.comment_disabled=t},expression:"comment_disabled"}},[n("el-radio",{attrs:{label:!0}},[e._v("\n          Close comment\n        ")]),e._v(" "),n("el-radio",{attrs:{label:!1}},[e._v("\n          Open comment\n        ")])],1)],1)],1)],1)},Q=[],Z={props:{value:{type:Boolean,default:!1}},computed:{comment_disabled:{get:function(){return this.value},set:function(e){this.$emit("input",e)}}}},ee=Z,te=Object(p["a"])(ee,Y,Q,!1,null,null,null),ne=te.exports,ie=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dropdown",{attrs:{"hide-on-click":!1,"show-timeout":100,trigger:"click"}},[n("el-button",{attrs:{plain:""}},[e._v("\n    Platfroms("+e._s(e.platforms.length)+")\n    "),n("i",{staticClass:"el-icon-caret-bottom el-icon--right"})]),e._v(" "),n("el-dropdown-menu",{staticClass:"no-border",attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-checkbox-group",{staticStyle:{padding:"5px 15px"},model:{value:e.platforms,callback:function(t){e.platforms=t},expression:"platforms"}},e._l(e.platformsOptions,(function(t){return n("el-checkbox",{key:t.key,attrs:{label:t.key}},[e._v("\n        "+e._s(t.name)+"\n      ")])})),1)],1)],1)},ae=[],oe={props:{value:{required:!0,default:function(){return[]},type:Array}},data:function(){return{platformsOptions:[{key:"a-platform",name:"a-platform"},{key:"b-platform",name:"b-platform"},{key:"c-platform",name:"c-platform"}]}},computed:{platforms:{get:function(){return this.value},set:function(e){this.$emit("input",e)}}}},re=oe,le=Object(p["a"])(re,ie,ae,!1,null,null,null),se=le.exports,ce=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dropdown",{attrs:{"show-timeout":100,trigger:"click"}},[n("el-button",{attrs:{plain:""}},[e._v("\n    Link\n    "),n("i",{staticClass:"el-icon-caret-bottom el-icon--right"})]),e._v(" "),n("el-dropdown-menu",{staticClass:"no-padding no-border",staticStyle:{width:"400px"},attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-form-item",{staticStyle:{"margin-bottom":"0px"},attrs:{"label-width":"0px",prop:"source_uri"}},[n("el-input",{attrs:{placeholder:"Please enter the content"},model:{value:e.source_uri,callback:function(t){e.source_uri=t},expression:"source_uri"}},[n("template",{slot:"prepend"},[e._v("\n          URL\n        ")])],2)],1)],1)],1)},ue=[],de={props:{value:{type:String,default:""}},computed:{source_uri:{get:function(){return this.value},set:function(e){this.$emit("input",e)}}}},me=de,pe=Object(p["a"])(me,ce,ue,!1,null,null,null),he=pe.exports,fe={status:"draft",title:"",content:"",content_short:"",source_uri:"",image_uri:"",display_time:void 0,id:void 0,platforms:["a-platform"],comment_disabled:!1,importance:0},ve={name:"ArticleDetail",components:{Tinymce:E,MDinput:z,Upload:P,Sticky:D["a"],Warning:J,CommentDropdown:ne,PlatformDropdown:se,SourceUrlDropdown:he},props:{isEdit:{type:Boolean,default:!1}},data:function(){var e=this,t=function(t,n,i){""===n?(e.$message({message:t.field+"为必传项",type:"error"}),i(new Error(t.field+"为必传项"))):i()},n=function(t,n,i){n?Object(H["validURL"])(n)?i():(e.$message({message:"外链url填写不正确",type:"error"}),i(new Error("外链url填写不正确"))):i()};return{postForm:Object.assign({},fe),loading:!1,userListOptions:[],rules:{image_uri:[{validator:t}],title:[{validator:t}],content:[{validator:t}],source_uri:[{validator:n,trigger:"blur"}]},tempRoute:{}}},computed:{contentShortLength:function(){return this.postForm.content_short.length},displayTime:{get:function(){return+new Date(this.postForm.display_time)},set:function(e){this.postForm.display_time=new Date(e)}}},created:function(){if(this.isEdit){var e=this.$route.params&&this.$route.params.id;this.fetchData(e)}this.tempRoute=Object.assign({},this.$route)},methods:{setTagsViewTitle:function(){var e="Edit Article",t=Object.assign({},this.tempRoute,{title:"".concat(e,"-").concat(this.postForm.id)});this.$store.dispatch("tagsView/updateVisitedView",t)},setPageTitle:function(){var e="Edit Article";document.title="".concat(e," - ").concat(this.postForm.id)},submitForm:function(){var e=this;this.$refs.postForm.validate((function(t){if(!t)return!1;e.loading=!0,e.$notify({title:"成功",message:"发布文章成功",type:"success",duration:2e3}),e.postForm.status="published",e.loading=!1}))},draftForm:function(){0!==this.postForm.content.length&&0!==this.postForm.title.length?(this.$message({message:"保存成功",type:"success",showClose:!0,duration:1e3}),this.postForm.status="draft"):this.$message({message:"请填写必要的标题和内容",type:"warning"})}}},ge=ve,be=(n("dc5d"),Object(p["a"])(ge,o,r,!1,null,"aa49d434",null)),ye=be.exports,_e={name:"CreateArticle",components:{ArticleDetail:ye}},we=_e,xe=Object(p["a"])(we,i,a,!1,null,null,null);t["default"]=xe.exports},"3e60":function(e,t,n){},"49b7":function(e,t,n){"use strict";n("a190")},5278:function(e,t,n){"use strict";n("2441")},"5dc3":function(e,t){e.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},"66f5":function(e,t,n){"use strict";n("6e39")},"6e39":function(e,t,n){},a190:function(e,t,n){},a35d:function(e,t,n){"use strict";n("ad02")},a83a:function(e,t,n){var i=n("9cff"),a=n("e0ff").set;e.exports=function(e,t,n){var o,r=t.constructor;return r!==n&&"function"==typeof r&&(o=r.prototype)!==n.prototype&&i(o)&&a&&a(e,o),e}},ad02:function(e,t,n){},b804:function(e,t,n){"use strict";var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{style:{height:e.height+"px",zIndex:e.zIndex}},[n("div",{class:e.className,style:{top:e.isSticky?e.stickyTop+"px":"",zIndex:e.zIndex,position:e.position,width:e.width,height:e.height+"px"}},[e._t("default",[n("div",[e._v("sticky")])])],2)])},a=[],o=(n("e680"),{name:"Sticky",props:{stickyTop:{type:Number,default:0},zIndex:{type:Number,default:1},className:{type:String,default:""}},data:function(){return{active:!1,position:"",width:void 0,height:void 0,isSticky:!1}},mounted:function(){this.height=this.$el.getBoundingClientRect().height,window.addEventListener("scroll",this.handleScroll),window.addEventListener("resize",this.handleResize)},activated:function(){this.handleScroll()},destroyed:function(){window.removeEventListener("scroll",this.handleScroll),window.removeEventListener("resize",this.handleResize)},methods:{sticky:function(){this.active||(this.position="fixed",this.active=!0,this.width=this.width+"px",this.isSticky=!0)},handleReset:function(){this.active&&this.reset()},reset:function(){this.position="",this.width="auto",this.active=!1,this.isSticky=!1},handleScroll:function(){var e=this.$el.getBoundingClientRect().width;this.width=e||"auto";var t=this.$el.getBoundingClientRect().top;t<this.stickyTop?this.sticky():this.handleReset()},handleResize:function(){this.isSticky&&(this.width=this.$el.getBoundingClientRect().width+"px")}}}),r=o,l=n("c701"),s=Object(l["a"])(r,i,a,!1,null,null,null);t["a"]=s.exports},dc5d:function(e,t,n){"use strict";n("3e60")},e0ff:function(e,t,n){var i=n("9cff"),a=n("a86f"),o=function(e,t){if(a(e),!i(t)&&null!==t)throw TypeError(t+": can't set as prototype!")};e.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(e,t,i){try{i=n("1e4d")(Function.call,n("285b").f(Object.prototype,"__proto__").set,2),i(e,[]),t=!(e instanceof Array)}catch(a){t=!0}return function(e,n){return o(e,n),t?e.__proto__=n:i(e,n),e}}({},!1):void 0),check:o}},e680:function(e,t,n){"use strict";var i=n("0b34"),a=n("4fd4"),o=n("cea2"),r=n("a83a"),l=n("5d10"),s=n("0926"),c=n("21d9").f,u=n("285b").f,d=n("bb8b").f,m=n("eb34").trim,p="Number",h=i[p],f=h,v=h.prototype,g=o(n("7ee3")(v))==p,b="trim"in String.prototype,y=function(e){var t=l(e,!1);if("string"==typeof t&&t.length>2){t=b?t.trim():m(t,3);var n,i,a,o=t.charCodeAt(0);if(43===o||45===o){if(n=t.charCodeAt(2),88===n||120===n)return NaN}else if(48===o){switch(t.charCodeAt(1)){case 66:case 98:i=2,a=49;break;case 79:case 111:i=8,a=55;break;default:return+t}for(var r,s=t.slice(2),c=0,u=s.length;c<u;c++)if(r=s.charCodeAt(c),r<48||r>a)return NaN;return parseInt(s,i)}}return+t};if(!h(" 0o1")||!h("0b1")||h("+0x1")){h=function(e){var t=arguments.length<1?0:e,n=this;return n instanceof h&&(g?s((function(){v.valueOf.call(n)})):o(n)!=p)?r(new f(y(t)),n,h):y(t)};for(var _,w=n("26df")?c(f):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),x=0;w.length>x;x++)a(f,_=w[x])&&!a(h,_)&&d(h,_,u(f,_));h.prototype=v,v.constructor=h,n("84e8")(i,p,h)}},eb34:function(e,t,n){var i=n("e99b"),a=n("3ab0"),o=n("0926"),r=n("5dc3"),l="["+r+"]",s="​",c=RegExp("^"+l+l+"*"),u=RegExp(l+l+"*$"),d=function(e,t,n){var a={},l=o((function(){return!!r[e]()||s[e]()!=s})),c=a[e]=l?t(m):r[e];n&&(a[n]=c),i(i.P+i.F*l,"String",a)},m=d.trim=function(e,t){return e=String(a(e)),1&t&&(e=e.replace(c,"")),2&t&&(e=e.replace(u,"")),e};e.exports=d}}]);