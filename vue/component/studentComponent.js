studentComponent = {
        template: `
        <div v-if="loading" class="spinner-border"></div>
        <div v-else class="student_card">
            <router-link to="/">
                <span class="material-symbols-outlined">
                arrow_back
                </span>
                </router-link>
            Студент {{student.id}}
            <div class = "student_data_row">
                <div class="form-label" >Фамилия <input class="form-control"  v-model="student.surname"></div>
                <div>Имя <input class="form-control" v-model="student.name"></div>
                <div>Отчество <input class="form-control" v-model="student.fath_name"></div>
            </div>
            <div class="form-label">Возраст <input class="form-control" v-model="student.age"></div>
            <div class="form-label">Специальность <input class="form-control" v-model="student.spec"></div>
            <div class = "student_data_row">
                <div class="form-label">Страна <input class="form-control" v-model="student.country"></div>
                <div class="form-label">Город <input class="form-control" v-model="student.city"></div>
            </div>
             <div>
                <button class="btn btn-dark" id="btn_edit" v-on:click="editStudent">Редактировать</button>
             </div>
             <div>
                <button class="btn btn-danger"v-on:click="deleteStudent">Удалить</button>
             </div>
        </div>
        `,
        data() {
            return {
                loading: true,
                student: null
            };
        },
        methods: {
            editStudent: function (event) {
             if (confirm('Вы уверены, что хотите изменить данные о студенте?')) {
                let error = false;
                let key_name = null;
                for (const [key, value] of Object.entries(this.student)) {
                  console.log(`${key} : ${value}`);
                    if (value === null || value === "") {
                    error = true;
                    key_name = key;
                    }
                }

                if(error){
                    alert('Input ' +key_name+ ', please');
                }else{
                    if(this.student.age<18){
                        alert('Вы как-то резко помолодели, скиньте рецепт зелья омолаживания на почту');
                        error = true;
                    }
                    if(this.student.age>100){
                        alert('Вы слишком постарели, куда Вам уже в студенты, а?');
                        error = true;
                    }
                }
                console.log(this.student);

                if(!error){
                axios.put('http://localhost:8080/student/' + this.student.id,
                JSON.stringify(this.student), {
                      headers:{'Content-Type': 'application/json; charset=utf-8'}
                  })
                   .then(response => {
                      console.log(response.data);
                      console.log('Student edited');
                      this.$router.push('/');
                   })
                   .catch(error => {
                      alert(error);
                   });
                }
            }},
            deleteStudent: function (event) {
               if (confirm('Вы уверены, что хотите удалить данные о студенте?')) {
                  axios.delete('http://localhost:8080/student/' + this.student.id)
                     .then(response => {
                        console.log('Student deleted');
                        this.$router.push('/');
                     })
                     .catch(error => {
                        alert(error);
                     });
               }
            },
        },
        mounted() {
        const id = this.$route.params.id;
        console.log(id);
           axios
               .get('http://localhost:8080/student/' + id, { mode: 'no-cors'})
               .then(response => {
                  this.student = response.data;
                  console.log(this.student.name);
                  input_name = "eafas";
                  console.log(input_name);
                  input_age = this.student.age;
                  input_surname = this.student.surname;
                  input_fath_name = this.student.fath_name;
                  input_city = this.student.city;
                  input_country = this.student.country;
                  input_spec = this.student.spec;
               })
               .finally(() => this.loading = false);
            }
        }