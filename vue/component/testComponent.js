//
testComponent = {
        template: `
        <router-link :to="{ name: 'student', params: { id: 123 } }">User</router-link>
        <div>124</div>
        `,
        data() {
            return {
                loading: true,
                student: null,
            };
        },
        methods: {
            addStudent: function (event) {
                this.$router.push('/addStudent');
            },
        },
        mounted() {
            }


        }