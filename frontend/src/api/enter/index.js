import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:80',
});

// 기업회원가입
function enterRegisterMember(enterData) {
    return instance.post('/enter/register', enterData)
}





export { enterRegisterMember };