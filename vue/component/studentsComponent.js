studentsComponent = {
        template: `
         <div v-if="loading" class="spinner-border"></div>
        <div v-else>
            <div class="table">
                <div class="caption">Список студентов</div>
                <div class="header">
                    <div class="">Номер</div>
                    <div>Имя</div>
                </div>
                <div id="student" class="student"  v-for="student in students">
                    <router-link :to="{ name: 'student', params: { id: student.id } }">
                        <div class="page-link" class="id">{{student.id}}</div>
                        <div class="page-link" class="name">{{student.name}}</div>
                    </router-link>
                </div>
            </div>
        </div><a href="index.html#/addStudent">Add student</a>
        `,
                data() {
            return {
                loading: true,
                students: null
            };
        },
        methods: {

            viewStudent: function (event) {
                this.$router.push('/' + student.id);
            },
        },
        mounted() {
           axios
               .get('http://localhost:8080/student', { mode: 'no-cors'})
               .then(response => (this.students = response.data))
               .finally(() => this.loading = false);
        }
}


