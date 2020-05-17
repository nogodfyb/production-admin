(function(e){function t(t){for(var a,s,i=t[0],l=t[1],c=t[2],d=0,p=[];d<i.length;d++)s=i[d],Object.prototype.hasOwnProperty.call(n,s)&&n[s]&&p.push(n[s][0]),n[s]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(e[a]=l[a]);u&&u(t);while(p.length)p.shift()();return o.push.apply(o,c||[]),r()}function r(){for(var e,t=0;t<o.length;t++){for(var r=o[t],a=!0,i=1;i<r.length;i++){var l=r[i];0!==n[l]&&(a=!1)}a&&(o.splice(t--,1),e=s(s.s=r[0]))}return e}var a={},n={app:0},o=[];function s(t){if(a[t])return a[t].exports;var r=a[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,s),r.l=!0,r.exports}s.m=e,s.c=a,s.d=function(e,t,r){s.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,t){if(1&t&&(e=s(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(s.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)s.d(r,a,function(t){return e[t]}.bind(null,a));return r},s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,"a",t),t},s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},s.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var c=0;c<i.length;c++)t(i[c]);var u=l;o.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("4cae")},"29ac":function(e,t,r){},"4cae":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var a=r("8bbf"),n=r.n(a),o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("router-view")],1)},s=[],i={name:"app"},l=i,c=r("2877"),u=Object(c["a"])(l,o,s,!1,null,null,null),d=u.exports,p=(r("ac1f"),r("5319"),r("6389")),m=r.n(p),b=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"login_container"},[r("div",{staticClass:"login_box"},[e._m(0),r("el-form",{ref:"loginFormRef",staticClass:"login_form",attrs:{"label-width":"0px",model:e.loginForm,rules:e.loginFormRules}},[r("el-form-item",{attrs:{prop:"username"}},[r("el-input",{attrs:{"prefix-icon":"iconfont icon-user"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),r("el-form-item",{attrs:{prop:"password"}},[r("el-input",{attrs:{"prefix-icon":"iconfont icon-3702mima",type:"password"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),r("el-form-item",{staticClass:"btns"},[r("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("登录")]),r("el-button",{attrs:{type:"info"},on:{click:function(t){return e.resetForm("loginFormRef")}}},[e._v("重置")])],1)],1)],1)])},f=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"avatar_box"},[a("img",{attrs:{src:r("cf05"),alt:""}})])}],g={data:function(){return{loginForm:{username:"admin",password:"admin"},loginFormRules:{username:[{required:!0,message:"请输入用户名称",trigger:"blur"},{min:3,max:10,message:"长度在 3 到 10 个字符",trigger:"blur"}],password:[{required:!0,message:"请输入用户密码",trigger:"blur"},{min:5,max:15,message:"长度在 5 到 15 个字符",trigger:"blur"}]}}},methods:{onSubmit:function(){var e=this;this.$refs.loginFormRef.validate((function(t){if(!t)return!1;e.$http.post("user/login",e.loginForm).then((function(t){if(200!==t.data.status)return e.$message.error("登录失败");e.$message.success("登录成功"),e.$router.push("home")}))}))},resetForm:function(e){this.$refs[e].resetFields()}}},h=g,v=(r("54c4"),Object(c["a"])(h,b,f,!1,null,"b7ded8a2",null)),y=v.exports,w=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticClass:"home-container"},[a("el-header",[a("div",[a("img",{staticStyle:{height:"50px",width:"50px"},attrs:{src:r("cf05"),alt:""}}),a("span",[e._v("生产作业计划管理系统")])]),a("el-button",{attrs:{type:"info"},on:{click:e.loginOut}},[e._v("退出")])],1),a("el-container",{staticStyle:{height:"850px"}},[a("el-aside",{attrs:{width:e.isCollapse?"64px":"200px"}},[a("div",{staticClass:"toggle-button",on:{click:e.toggleCollapse}},[e._v("|||")]),a("el-menu",{attrs:{"background-color":"#333744","text-color":"#fff","active-text-color":"#409eef","unique-opened":"",collapse:e.isCollapse,"collapse-transition":!1,router:"","default-active":e.activePath}},e._l(e.menuList,(function(t){return a("el-submenu",{key:t.id,attrs:{index:t.id+""}},[a("template",{slot:"title"},[a("i",{class:e.iconsObj[t.id]}),a("span",[e._v(e._s(t.authName))])]),e._l(t.children,(function(t){return a("el-menu-item",{key:t.id,attrs:{index:t.path+""},on:{click:function(r){return e.saveNavState(t.path)}}},[a("template",{slot:"title"},[a("i",{staticClass:"el-icon-menu"}),a("span",[e._v(e._s(t.authName))])])],2)}))],2)})),1)],1),a("el-main",[a("router-view")],1)],1)],1)},x=[],_=(r("96cf"),r("1da1")),k={data:function(){return{menuList:[],iconsObj:{1:"iconfont icon-user",2:"iconfont icon-tijikongjian",3:"iconfont icon-shangpin",4:"iconfont icon-danju",5:"iconfont icon-baobiao"},isCollapse:!1,activePath:""}},created:function(){this.getMenuList(),this.activePath=window.sessionStorage.getItem("activePath")},methods:{loginOut:function(){document.cookie="JSESSIONID=",window.sessionStorage.removeItem("activePath"),this.$router.push("/login")},getMenuList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("menu/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error(a.msg));case 6:e.menuList=a.data;case 7:case"end":return t.stop()}}),t)})))()},toggleCollapse:function(){this.isCollapse=!this.isCollapse},saveNavState:function(e){window.sessionStorage.setItem("activePath",e),this.activePath=e}}},$=k,R=(r("e1ad"),Object(c["a"])($,w,x,!1,null,"7a26366d",null)),I=R.exports,F=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},L=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("h3",[e._v("欢迎来到我的小作品！请点击左边菜单栏开始浏览！")])])}],P=(r("c975"),{created:function(){var e=window.location.href;e.indexOf("?")}}),C=P,D=Object(c["a"])(C,F,L,!1,null,"2a9e98db",null),O=D.exports,j=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("用户管理")]),r("el-breadcrumb-item",[e._v("用户列表")])],1),r("el-card",[r("el-row",{attrs:{gutter:20}},[r("el-col",{attrs:{span:8}},[r("el-input",{attrs:{placeholder:"请输入内容",clearable:""},on:{clear:e.getUserList},model:{value:e.queryInfo.query,callback:function(t){e.$set(e.queryInfo,"query",t)},expression:"queryInfo.query"}},[r("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:e.getUserList},slot:"append"})],1)],1),r("el-col",{attrs:{span:4}},[r("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogVisible=!0}}},[e._v("添加用户")])],1)],1),r("el-table",{attrs:{data:e.userList,border:"",stripe:"",height:"650"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"姓名",prop:"username"}}),r("el-table-column",{attrs:{label:"邮箱",prop:"email"}}),r("el-table-column",{attrs:{label:"电话",prop:"mobile"}}),r("el-table-column",{attrs:{label:"角色",prop:"roleName"}}),r("el-table-column",{attrs:{label:"状态(是否开启)"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-switch",{on:{change:function(r){return e.userStateChanged(t.row)}},model:{value:t.row.isAlive,callback:function(r){e.$set(t.row,"isAlive",r)},expression:"scope.row.isAlive"}})]}}])}),r("el-table-column",{attrs:{label:"操作",width:"300px"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"primary",icon:"el-icon-edit",size:"mini"},on:{click:function(r){return e.showEditDialog(t.row.id)}}},[e._v("编辑")]),r("el-button",{attrs:{type:"danger",icon:"el-icon-delete",size:"mini"},on:{click:function(r){return e.deleteUser(t.row.id)}}},[e._v("删除")]),r("el-tooltip",{attrs:{effect:"dark",content:"分配角色",placement:"top-start",enterable:!1}},[r("el-button",{attrs:{type:"warning",icon:"el-icon-setting",size:"mini"},on:{click:function(r){return e.setRole(t.row)}}},[e._v("分配角色")])],1)]}}])})],1),r("el-pagination",{attrs:{"current-page":e.queryInfo.pageNum,"page-sizes":[3,5,10,15],"page-size":e.queryInfo.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1),r("el-dialog",{attrs:{title:"添加用户",visible:e.dialogVisible,width:"50%"},on:{"update:visible":function(t){e.dialogVisible=t},close:e.addDialogClosed}},[r("el-form",{ref:"addFormRef",attrs:{model:e.addForm,rules:e.addFormRules,"label-width":"70px"}},[r("el-form-item",{attrs:{label:"用户名",prop:"username"}},[r("el-input",{model:{value:e.addForm.username,callback:function(t){e.$set(e.addForm,"username",t)},expression:"addForm.username"}})],1),r("el-form-item",{attrs:{label:"密码",prop:"password"}},[r("el-input",{model:{value:e.addForm.password,callback:function(t){e.$set(e.addForm,"password",t)},expression:"addForm.password"}})],1),r("el-form-item",{attrs:{label:"手机",prop:"mobile"}},[r("el-input",{model:{value:e.addForm.mobile,callback:function(t){e.$set(e.addForm,"mobile",t)},expression:"addForm.mobile"}})],1),r("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[r("el-input",{model:{value:e.addForm.email,callback:function(t){e.$set(e.addForm,"email",t)},expression:"addForm.email"}})],1)],1),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.addUser}},[e._v("确 定")])],1)],1),r("el-dialog",{attrs:{title:"修改用户",visible:e.editDialogVisible,width:"50%"},on:{"update:visible":function(t){e.editDialogVisible=t},close:e.editDialogClosed}},[r("el-form",{ref:"editFormRef",attrs:{model:e.editForm,rules:e.editFormRules,"label-width":"70px"}},[r("el-form-item",{attrs:{label:"用户名"}},[r("el-input",{attrs:{disabled:""},model:{value:e.editForm.username,callback:function(t){e.$set(e.editForm,"username",t)},expression:"editForm.username"}})],1),r("el-form-item",{attrs:{label:"手机",prop:"mobile"}},[r("el-input",{model:{value:e.editForm.mobile,callback:function(t){e.$set(e.editForm,"mobile",t)},expression:"editForm.mobile"}})],1),r("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[r("el-input",{model:{value:e.editForm.email,callback:function(t){e.$set(e.editForm,"email",t)},expression:"editForm.email"}})],1)],1),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.editDialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.editUser}},[e._v("确 定")])],1)],1),r("el-dialog",{attrs:{title:"提示",visible:e.setRoleDialogVisible,width:"50%"},on:{"update:visible":function(t){e.setRoleDialogVisible=t},close:e.setRoleDialogClosed}},[r("div",[r("p",[e._v("当前的用户："+e._s(e.userInfo.username))]),r("p",[e._v("当前的角色："+e._s(e.userInfo.roleName))]),r("p",[e._v("分配新角色: "),r("el-select",{attrs:{placeholder:"请选择"},model:{value:e.selectedId,callback:function(t){e.selectedId=t},expression:"selectedId"}},e._l(e.rolesList,(function(e){return r("el-option",{key:e.roleId,attrs:{label:e.roleName,value:e.roleId}})})),1)],1)]),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.setRoleDialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.saveRoleInfo}},[e._v("确 定")])],1)])],1)},S=[],N=(r("99af"),{data:function(){var e=function(e,t,r){var a=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;if(a.test(t))return r();r(new Error("请输入合法的邮箱"))},t=function(e,t,r){var a=/^1[3456789]\d{9}$/;if(a.test(t))return r();r(new Error("请输入合法的手机号"))};return{queryInfo:{query:"",pageNum:1,pageSize:5},userList:[],total:0,dialogVisible:!1,editDialogVisible:!1,setRoleDialogVisible:!1,addForm:{username:"",password:"",mobile:"",email:""},editForm:{},userInfo:{},rolesList:[],selectedId:"",addFormRules:{username:[{required:!0,message:"请输入用户名称",trigger:"blur"},{min:3,max:10,message:"长度在 3 到 10 个字符",trigger:"blur"}],password:[{required:!0,message:"请输入用户密码",trigger:"blur"},{min:5,max:15,message:"长度在 5 到 15 个字符",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱",trigger:"blur"},{validator:e,trigger:"blur",message:"请输入合法的邮箱"}],mobile:[{required:!0,message:"请输入手机号",trigger:"blur"},{validator:t,trigger:"blur",message:"请输入而合法的手机号"}]},editFormRules:{email:[{required:!0,message:"请输入邮箱",trigger:"blur"},{validator:e,trigger:"blur",message:"请输入合法的邮箱"}],mobile:[{required:!0,message:"请输入手机号",trigger:"blur"},{validator:t,trigger:"blur",message:"请输入而合法的手机号"}]}}},created:function(){this.getUserList()},methods:{getUserList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("user/users",{params:e.queryInfo});case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取用户列表失败！"));case 6:e.userList=a.data.list,e.total=a.data.total;case 8:case"end":return t.stop()}}),t)})))()},handleSizeChange:function(e){this.queryInfo.pageSize=e,this.getUserList()},handleCurrentChange:function(e){this.queryInfo.pageNum=e,this.getUserList()},userStateChanged:function(e){var t=this;return Object(_["a"])(regeneratorRuntime.mark((function r(){var a,n;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,t.$http.put("user/".concat(e.id,"/state/").concat(e.isAlive));case 2:if(a=r.sent,n=a.data,200===n.status){r.next=7;break}return e.isAlive=!e.isAlive,r.abrupt("return",t.$message.error("更新用户状态失败！"));case 7:t.$message.success("更新用户状态成功！");case 8:case"end":return r.stop()}}),r)})))()},addDialogClosed:function(){this.$refs.addFormRef.resetFields()},addUser:function(){var e=this;this.$refs.addFormRef.validate(function(){var t=Object(_["a"])(regeneratorRuntime.mark((function t(r){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(r){t.next=2;break}return t.abrupt("return",!1);case 2:return t.next=4,e.$http.post("user/add",e.addForm);case 4:if(a=t.sent,n=a.data,200===n.status){t.next=8;break}return t.abrupt("return",e.$message.error("添加用户失败！"));case 8:e.$message.success("添加用户成功！"),e.dialogVisible=!1,e.getUserList();case 11:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())},showEditDialog:function(e){var t=this;return Object(_["a"])(regeneratorRuntime.mark((function r(){var a,n;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return t.editDialogVisible=!0,r.next=3,t.$http.get("user/users/".concat(e));case 3:if(a=r.sent,n=a.data,200===n.status){r.next=8;break}return t.$message.error("获取用户信息失败"),r.abrupt("return",!1);case 8:t.editForm=n.data;case 9:case"end":return r.stop()}}),r)})))()},editDialogClosed:function(){this.$refs.editFormRef.resetFields()},editUser:function(){var e=this;this.$refs.editFormRef.validate(function(){var t=Object(_["a"])(regeneratorRuntime.mark((function t(r){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(r){t.next=2;break}return t.abrupt("return",!1);case 2:return t.next=4,e.$http.put("user/users",e.editForm);case 4:a=t.sent,n=a.data,201!==n.status&&e.$message.error("修改用户失败！"),e.$message.success("修改用户成功！"),e.editDialogVisible=!1,e.getUserList();case 10:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())},deleteUser:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){return t.$message.error("暂不开启删除功能")})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},deleteUserById:function(e){var t=this;return Object(_["a"])(regeneratorRuntime.mark((function r(){var a,n;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,t.$http.delete("user/users/".concat(e));case 2:if(a=r.sent,n=a.data,200===n.status){r.next=6;break}return r.abrupt("return",t.$message.error("删除失败"));case 6:t.$message({type:"success",message:"删除成功!"}),t.getUserList();case 8:case"end":return r.stop()}}),r)})))()},setRole:function(e){this.userInfo=e,this.rolesList=[{roleId:101,roleName:"超级管理员"},{roleId:102,roleName:"普通管理员"},{roleId:103,roleName:"普通用户"}],this.setRoleDialogVisible=!0},saveRoleInfo:function(){return this.selectedId?this.$message.error("当前不开放分配角色权限！"):this.$message.error("没有选择新角色")},setRoleDialogClosed:function(){this.selectedId="",this.userInfo={}}}}),V=N,q=Object(c["a"])(V,j,S,!1,null,"ae30dca6",null),z=q.exports,E=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("权限管理")]),r("el-breadcrumb-item",[e._v("权限列表")])],1),r("el-card",[r("el-table",{attrs:{data:e.rightsList,border:"",stripe:"",height:"700"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"权限名称",prop:"authName"}}),r("el-table-column",{attrs:{label:"路径",prop:"controller"}}),r("el-table-column",{attrs:{label:"权限等级",prop:"level"},scopedSlots:e._u([{key:"default",fn:function(t){return["0"===t.row.level?r("el-tag",[e._v("一级")]):"1"===t.row.level?r("el-tag",{attrs:{type:"success"}},[e._v("二级")]):r("el-tag",{attrs:{type:"warning"}},[e._v("三级")])]}}])})],1)],1)],1)},M=[],U={data:function(){return{rightsList:[]}},created:function(){this.getRightsList()},methods:{getRightsList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("rights/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取权限列表失败！"));case 6:e.rightsList=a.data;case 7:case"end":return t.stop()}}),t)})))()}}},T=U,A=Object(c["a"])(T,E,M,!1,null,"6536b6ee",null),K=A.exports,B=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("权限管理")]),r("el-breadcrumb-item",[e._v("角色列表")])],1),r("el-card",[r("el-row",[r("el-col",[r("el-button",{attrs:{type:"primary"},on:{click:e.addRole}},[e._v("添加角色")])],1)],1),r("el-table",{attrs:{data:e.roleList,border:"",stripe:""}},[r("el-table-column",{attrs:{type:"expand"},scopedSlots:e._u([{key:"default",fn:function(t){return e._l(t.row.children,(function(t,a){return r("el-row",{key:t.id,class:["bdbottom",0===a?"bdtop":"","vcenter"]},[r("el-col",{attrs:{span:5}},[r("el-tag",[e._v(e._s(t.authName))]),r("i",{staticClass:"el-icon-caret-right"})],1),r("el-col",{attrs:{span:19}},e._l(t.children,(function(t,a){return r("el-row",{key:t.id,class:[0===a?"":"bdtop","vcenter"]},[r("el-col",{attrs:{span:6}},[r("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.authName))]),r("i",{staticClass:"el-icon-caret-right"})],1),r("el-col",{attrs:{span:18}},e._l(t.children,(function(t){return r("el-tag",{key:t.id,attrs:{type:"warning",closable:""},on:{close:e.removeRightById}},[e._v(" "+e._s(t.authName)+" ")])})),1)],1)})),1)],1)}))}}])}),r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"角色名称",prop:"roleName"}}),r("el-table-column",{attrs:{label:"角色描述",prop:"roleDesc"}}),r("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"primary",icon:"el-icon-edit",size:"mini"},on:{click:e.editRole}},[e._v("编辑")]),r("el-button",{attrs:{type:"danger",icon:"el-icon-delete",size:"mini"},on:{click:e.deleteRole}},[e._v("删除")]),r("el-tooltip",{attrs:{effect:"dark",content:"分配权限",placement:"top-start",enterable:!1}},[r("el-button",{attrs:{type:"warning",icon:"el-icon-setting",size:"mini"},on:{click:function(r){return e.showSetRightDialog(t.row)}}},[e._v(" 分配权限 ")])],1)]}}])})],1)],1),r("el-dialog",{attrs:{title:"分配权限",visible:e.setRightDialogVisible,width:"30%"},on:{"update:visible":function(t){e.setRightDialogVisible=t},close:e.setRightDialogClosed}},[r("el-tree",{ref:"treeRef",attrs:{data:e.rightsList,props:e.treeProps,"show-checkbox":"","node-key":"id","default-expand-all":"","default-checked-keys":e.defKeys}}),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.setRightDialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.allotRights}},[e._v("确 定")])],1)],1)],1)},Q=[],J=(r("4160"),r("159b"),r("2909")),Z={data:function(){return{roleList:[],setRightDialogVisible:!1,rightsList:[],treeProps:{label:"authName",children:"children"},defKeys:[],roleId:""}},created:function(){this.getRolesList()},methods:{getRolesList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("role/roles");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取角色列表失败！"));case 6:e.roleList=a.data;case 7:case"end":return t.stop()}}),t)})))()},removeRightById:function(){var e=this;this.$confirm("此操作将永久删除该权限, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},showSetRightDialog:function(e){var t=this;return Object(_["a"])(regeneratorRuntime.mark((function r(){var a,n;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return t.roleId=e.roleId,r.next=3,t.$http.get("rights/tree");case 3:if(a=r.sent,n=a.data,200===n.status){r.next=7;break}return r.abrupt("return",t.$message.error("获取权限数据失败！"));case 7:t.rightsList=n.data,t.getLeafKeys(e,t.defKeys),t.setRightDialogVisible=!0;case 10:case"end":return r.stop()}}),r)})))()},getLeafKeys:function(e,t){var r=this;if(!e.children)return t.push(e.id);e.children.forEach((function(e){return r.getLeafKeys(e,t)}))},setRightDialogClosed:function(){this.defKeys=[]},allotRights:function(){var e=[].concat(Object(J["a"])(this.$refs.treeRef.getCheckedKeys()),Object(J["a"])(this.$refs.treeRef.getHalfCheckedKeys()));this.$message.success("收到您点中的所有权限id:["+e+"]但目前不做更新")},addRole:function(){return this.$message.error("暂不开放添加！")},editRole:function(){return this.$message.error("暂不开放编辑！")},deleteRole:function(){return this.$message.error("暂不开放删除！")}}},H=Z,G=(r("d688"),Object(c["a"])(H,B,Q,!1,null,"777073b6",null)),W=G.exports,X=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("机台与产品")]),r("el-breadcrumb-item",[e._v("机台列表")])],1),r("el-card",[r("el-table",{attrs:{data:e.machineList,border:"",stripe:"",height:"700"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"机台ID",prop:"id"}}),r("el-table-column",{attrs:{label:"机台编号",prop:"code"}}),r("el-table-column",{attrs:{label:"机台描述",prop:"description"}})],1)],1)],1)},Y=[],ee={created:function(){this.getMachineList()},data:function(){return{machineList:[]}},methods:{getMachineList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("machine/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取机台列表失败！"));case 6:e.machineList=a.data;case 7:case"end":return t.stop()}}),t)})))()}}},te=ee,re=Object(c["a"])(te,X,Y,!1,null,"d10f6f42",null),ae=re.exports,ne=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("机台与产品")]),r("el-breadcrumb-item",[e._v("产品列表")])],1),r("el-card",[r("el-table",{attrs:{data:e.productList,border:"",stripe:"",height:"700"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"产品编号",prop:"code"}}),r("el-table-column",{attrs:{label:"产品名称",prop:"name"}}),r("el-table-column",{attrs:{label:"产品单价/元",prop:"unitPrice"}})],1)],1)],1)},oe=[],se={created:function(){this.getProductList()},data:function(){return{productList:[]}},methods:{getProductList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("product/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取产品列表失败！"));case 6:e.productList=a.data;case 7:case"end":return t.stop()}}),t)})))()}}},ie=se,le=Object(c["a"])(ie,ne,oe,!1,null,"86fdc232",null),ce=le.exports,ue=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("机台与产品")]),r("el-breadcrumb-item",[e._v("机台产能")])],1),r("el-card",[r("el-table",{attrs:{data:e.productList,border:"",stripe:"",height:"700"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"机台编号",prop:"machineCode"}}),r("el-table-column",{attrs:{label:"日平均产量",prop:"dailyProduction"}}),r("el-table-column",{attrs:{label:"机台描述",prop:"description"}}),r("el-table-column",{attrs:{label:"产品名称",prop:"name"}}),r("el-table-column",{attrs:{label:"产品单价",prop:"unitPrice"}})],1)],1)],1)},de=[],pe={created:function(){this.getProductList()},data:function(){return{productList:[]}},methods:{getProductList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("productivity/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取产能列表失败！"));case 6:e.productList=a.data;case 7:case"end":return t.stop()}}),t)})))()}}},me=pe,be=Object(c["a"])(me,ue,de,!1,null,"0c5dbc62",null),fe=be.exports,ge=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("生产计划安排")]),r("el-breadcrumb-item",[e._v("计划批次列表")])],1),r("el-card",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addDialogVisible=!0}}},[e._v("添加计划")]),r("p",[e._v("注意：计划批次的计划产量不得小于当天产能!")]),r("el-table",{attrs:{data:e.planItemList,border:"",stripe:"",height:"600"},on:{"selection-change":e.changeFun}},[r("el-table-column",{attrs:{type:"selection",width:"55"}}),r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"计划批次号",prop:"planNo"}}),r("el-table-column",{attrs:{label:"产品名称",prop:"name"}}),r("el-table-column",{attrs:{label:"计划生产数量",prop:"productQuantity"}}),r("el-table-column",{attrs:{label:"开始日期",prop:"startTime"}})],1),r("el-button",{staticStyle:{"margin-top":"15px"},attrs:{type:"success"},on:{click:e.generateProductionPlans}},[e._v("分配各机台生产计划")])],1),r("el-dialog",{attrs:{visible:e.addDialogVisible,width:"50%",title:"添加计划","close-on-click-modal":!1,"close-on-press-escape":!1},on:{"update:visible":function(t){e.addDialogVisible=t},close:e.addPlanDialogClosed}},[r("el-form",{attrs:{"label-width":"100px"}},[r("el-form-item",{attrs:{label:"计划批次号"}},[r("el-select",{attrs:{placeholder:"请选择"},model:{value:e.planForm.planNo,callback:function(t){e.$set(e.planForm,"planNo",t)},expression:"planForm.planNo"}},e._l(e.options,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"产品编号"}},[r("el-select",{attrs:{placeholder:"请选择"},model:{value:e.planForm.productCode,callback:function(t){e.$set(e.planForm,"productCode",t)},expression:"planForm.productCode"}},e._l(e.productionOptions,(function(e){return r("el-option",{key:e.productId,attrs:{label:e.label,value:e.productId}})})),1)],1),r("el-form-item",{attrs:{label:"计划生产数量"}},[r("el-input",{staticStyle:{width:"217px"},model:{value:e.planForm.productQuantity,callback:function(t){e.$set(e.planForm,"productQuantity",e._n(t))},expression:"planForm.productQuantity"}})],1),r("el-form-item",{attrs:{label:"起始时间"}},[r("el-date-picker",{attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.planForm.startTime,callback:function(t){e.$set(e.planForm,"startTime",t)},expression:"planForm.startTime"}})],1)],1),r("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.addDialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.addPlan}},[e._v("确 定")])],1)],1),r("el-dialog",{attrs:{visible:e.generateDialogVisible,width:"12%","show-close":!1,"close-on-click-modal":!1,"close-on-press-escape":!1},on:{"update:visible":function(t){e.generateDialogVisible=t},close:e.generateDialogClosed}},[r("el-progress",{attrs:{type:"circle",percentage:e.currentPercentage}})],1)],1)},he=[],ve=(r("d81d"),{created:function(){this.getPlanItemList()},data:function(){return{planItemList:[],addDialogVisible:!1,generateDialogVisible:!1,currentPercentage:20,options:[{value:"202005",label:"202005"},{value:"202006",label:"202006"},{value:"202007",label:"202007"}],planForm:{planNo:void 0,productCode:void 0,productQuantity:void 0,startTime:void 0},productionOptions:[{productId:1001,label:"天府RD-109"},{productId:1002,label:"天府RD-110A"},{productId:1003,label:"天府RD-123"}],selectedPlanItemIds:[]}},methods:{getPlanItemList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("plan-item/list");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取计划列表失败！"));case 6:e.planItemList=a.data;case 7:case"end":return t.stop()}}),t)})))()},addPlanDialogClosed:function(){this.planForm={}},addPlan:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.post("plan-item/add",e.planForm);case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("添加计划失败！选择的日期不能小于当天！"));case 6:e.addDialogVisible=!1,e.getPlanItemList();case 8:case"end":return t.stop()}}),t)})))()},changeFun:function(e){this.selectedPlanItemIds=e.map((function(e){return e.id}))},generateProductionPlans:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(0!==e.selectedPlanItemIds.length){t.next=2;break}return t.abrupt("return",e.$message.error("您没有选中任何计划！"));case 2:return e.generateDialogVisible=!0,t.next=5,e.$http.post("plan-item/generateProductionPlans",e.selectedPlanItemIds);case 5:if(r=t.sent,a=r.data,200===a.status){t.next=10;break}return e.generateDialogVisible=!1,t.abrupt("return",e.$message.error("操作失败，计划批次的时间顺序不能为逆序！"));case 10:e.currentPercentage=100,e.generateDialogVisible=!1,e.$message.success("已经分配好生产计划！请到机台生产计划列表查看"),e.getPlanItemList();case 14:case"end":return t.stop()}}),t)})))()},generateDialogClosed:function(){this.currentPercentage=20}}}),ye=ve,we=Object(c["a"])(ye,ge,he,!1,null,"c7e48342",null),xe=we.exports,_e=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("生产计划安排")]),r("el-breadcrumb-item",[e._v("机台生产计划列表")])],1),r("el-card",[r("el-date-picker",{attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},on:{change:e.selectDate},model:{value:e.queryInfo.productionDate,callback:function(t){e.$set(e.queryInfo,"productionDate",t)},expression:"queryInfo.productionDate"}}),r("el-select",{staticStyle:{"margin-left":"20px"},attrs:{placeholder:"请选择计划批次号"},on:{change:e.selectPlanNo},model:{value:e.queryInfo.planNo,callback:function(t){e.$set(e.queryInfo,"planNo",t)},expression:"queryInfo.planNo"}},e._l(e.options,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),r("el-table",{attrs:{data:e.machinePlanList,border:"",stripe:"",height:"650"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"机台编码",prop:"machineCode"}}),r("el-table-column",{attrs:{label:"计划批次号",prop:"planNo"}}),r("el-table-column",{attrs:{label:"生产日期",prop:"productionDate"}}),r("el-table-column",{attrs:{label:"生产班次",prop:"shift"}}),r("el-table-column",{attrs:{label:"产品编码",prop:"productCode"}}),r("el-table-column",{attrs:{label:"计划产量",prop:"scheduledProduction"}})],1),r("el-pagination",{attrs:{"current-page":e.queryInfo.pageNum,"page-sizes":[5,10,15,20],"page-size":e.queryInfo.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)},ke=[],$e={created:function(){this.getMachinePlanList()},data:function(){return{machinePlanList:[],queryInfo:{productionDate:"",planNo:"",pageNum:1,pageSize:10},total:0,options:[{value:"202005",label:"202005"},{value:"202006",label:"202006"},{value:"202007",label:"202007"}]}},methods:{getMachinePlanList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("machine-plan/list",{params:e.queryInfo});case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取机台计划列表失败！"));case 6:e.machinePlanList=a.data.list,e.total=a.data.total;case 8:case"end":return t.stop()}}),t)})))()},handleSizeChange:function(e){this.queryInfo.pageSize=e,this.getMachinePlanList()},handleCurrentChange:function(e){this.queryInfo.pageNum=e,this.getMachinePlanList()},selectDate:function(){this.getMachinePlanList()},selectPlanNo:function(){this.getMachinePlanList()}}},Re=$e,Ie=Object(c["a"])(Re,_e,ke,!1,null,"4290e834",null),Fe=Ie.exports,Le=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v("生产计划安排")]),r("el-breadcrumb-item",[e._v("已分配的计划批次")])],1),r("el-card",[r("el-table",{attrs:{data:e.planItemList,border:"",stripe:"",height:"600"}},[r("el-table-column",{attrs:{type:"index"}}),r("el-table-column",{attrs:{label:"计划批次号",prop:"planNo"}}),r("el-table-column",{attrs:{label:"产品名称",prop:"name"}}),r("el-table-column",{attrs:{label:"计划生产数量",prop:"productQuantity"}}),r("el-table-column",{attrs:{label:"开始日期",prop:"startTime"}})],1)],1)],1)},Pe=[],Ce={created:function(){this.getPlanItemList()},data:function(){return{planItemList:[]}},methods:{getPlanItemList:function(){var e=this;return Object(_["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.get("plan-item/list/assign");case 2:if(r=t.sent,a=r.data,200===a.status){t.next=6;break}return t.abrupt("return",e.$message.error("获取已分配计划列表失败！"));case 6:e.planItemList=a.data;case 7:case"end":return t.stop()}}),t)})))()}}},De=Ce,Oe=Object(c["a"])(De,Le,Pe,!1,null,"444d2b7a",null),je=Oe.exports;n.a.use(m.a);var Se=[{path:"/",redirect:"/login"},{path:"/login",component:y},{path:"/home",component:I,redirect:"/welcome",children:[{path:"/welcome",component:O},{path:"/users",component:z},{path:"/rights",component:K},{path:"/roles",component:W},{path:"/machines",component:ae},{path:"/products",component:ce},{path:"/productivitys",component:fe},{path:"/plans",component:xe},{path:"/machinePlans",component:Fe},{path:"/assignPlans",component:je}]}],Ne=new m.a({routes:Se});Ne.beforeEach((function(e,t,r){if("/login"===e.path)return r();var a=document.cookie.replace(/(?:(?:^|.*;\s*)JSESSIONID\s*\=\s*([^;]*).*$)|^.*$/,"$1");if(!a)return r("/login");r()}));var Ve=Ne,qe=(r("aede"),r("82da"),r("cebe")),ze=r.n(qe);ze.a.defaults.baseURL="http://112.74.51.188:8080/production/",ze.a.defaults.withCredentials=!0,n.a.prototype.$http=ze.a,n.a.config.productionTip=!1,new n.a({router:Ve,render:function(e){return e(d)}}).$mount("#app")},"4cb2":function(e,t,r){},"54c4":function(e,t,r){"use strict";var a=r("29ac"),n=r.n(a);n.a},6389:function(e,t){e.exports=VueRouter},"82da":function(e,t,r){},"8bbf":function(e,t){e.exports=Vue},a1da:function(e,t,r){},aede:function(e,t,r){},cebe:function(e,t){e.exports=axios},cf05:function(e,t,r){e.exports=r.p+"img/logo.82b9c7a5.png"},d688:function(e,t,r){"use strict";var a=r("a1da"),n=r.n(a);n.a},e1ad:function(e,t,r){"use strict";var a=r("4cb2"),n=r.n(a);n.a}});
//# sourceMappingURL=app.d47ff259.js.map