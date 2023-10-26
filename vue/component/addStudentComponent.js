addStudentComponent = {
                template: `
                <div>
                    <div class="add-form">
                        <div class="form-check form-switch">
                            <input class="form-check-input" v-model="light_profile" v-on:click="changeMode" type="checkbox"
                                id="mySwitch" name="darkmode">
                            <label class="form-check-label" for="mySwitch">Создать упрощенную версию профиля</label>
                        </div>

                        <div class="title" class="caption">Форма добавления студента</div>
                        <form>
                            <div>
                                <div><input type="number" v-model="student.id" placeholder="Number of student" required></div>
                                <div><input type="text" v-model="student.name" placeholder="Name of student" required></div>
                                <div v-if="!light_profile">
                                    <div><input type="text" v-model="student.surname" placeholder="Surname of student"></div>
                                    <div><input type="text" v-model="student.fath_name" placeholder="Father name of student"></div>
                                    <div><input type="text" v-model="student.country" placeholder="Country of student"></div>
                                    <div><input type="text" v-model="student.city" placeholder="City of student"></div>
                                    <div><input type="number" min="18" max ="100" v-model="student.age" placeholder="Age of student"></div>
                                    <div><input type="text" v-model="student.spec" placeholder="Speciality of student"></div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="button-container">
                        <div class="buttons">
                            <div><button class="button" v-on:click="addStudent">Save</button>
                                <button class="button" v-on:click="cancel">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
                `,
        data() {
            return {
                student: {
                    name: null,
                    id: null,
                    surname: null,
                    fath_name: null,
                    country: null,
                    city: null,
                    age: null,
                    spec: null
                },
                light_profile: false
            };
        },
        methods: {
            addStudent: function (event) {
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
                        alert('Вы слишком молоды для регистрации');
                        error = true;
                    }
                    if(this.student.age>100){
                        alert('Вы слишком стары для регистрации');
                        error = true;
                    }
                }
                console.log(this.student);

                if(!error){
                    console.log(this.student.name);
                    axios.post('http://localhost:8080/student',
                        JSON.stringify(this.student), {
                            headers:{'Content-Type': 'application/json; charset=utf-8'}
                        }
                    )
                    .then(response =>{
                        console.log('add successful');
                        this.$router.push('/');
                    })
                }
            },
            cancel: function (event) {
                this.$router.push('/');
            },
            changeMode: function (event) {
                console.log(this.light_profile);
                //this.light_profile= true;
            }
        },
        mounted() {
           axios
               .get('http://localhost:8080/student', { mode: 'no-cors'})
               .then(response => (this.students = response.data))
               .finally(() => this.loading = false);
            }
        }
