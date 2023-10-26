const routes = [
   { path: "/", component: studentsComponent },
   { path: "/students", component: studentsComponent },
   { path: '/:id(\\d+)', name: "student", component: studentComponent },
   { path: "/addStudent", component: addStudentComponent },
   { path: "/test", component: testComponent }
  // { path: "/deleteStudent", component: deleteStudentComponent },
  // { path: "/editStudent", component: editStudentComponent }
]

const router = new VueRouter.createRouter({
   history: VueRouter.createWebHashHistory(),
   routes
})

const app = Vue.createApp({})
app.use(router)
app.mount('#app')