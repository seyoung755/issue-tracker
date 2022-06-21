import axios from 'axios';

import { API_PREFIX } from '@/constant/api';

const instance = axios.create({
  baseURL: API_PREFIX, // TODO: constant로 분리하기
  timeout: 2500,
  headers: {},
});

instance.interceptors.request.use(
  config => {
    // 요청을 보내기 전에 수행할 로직
    // TODO: refresh token 체크하는 함수 만들기
    return config;
  },
  error => {
    // 요청 에러가 발생했을 때 수행할 로직
    console.log(error); // 디버깅
    return Promise.reject(error);
  },
);

// 학습용 주석:  https://yamoo9.github.io/axios/guide/error-handling.html
instance.interceptors.response.use(
  response => {
    // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 데이터가 있는 작업 수행
    return response;
  },
  error => {
    // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 오류가 있는 작업 수행
    if (error.response) {
      // 요청이 이루어졌으며 서버가 2xx의 범위를 벗어나는 상태 코드로 응답했습니다.
      // response: {data, status, headers}
      return Promise.reject(error.response.data);
    }
    if (error.request) {
      // 요청이 이루어 졌으나 응답을 받지 못했습니다.
      // `error.request`는 브라우저의 XMLHttpRequest 인스턴스 또는
      // Node.js의 http.ClientRequest 인스턴스입니다.
      console.log(error.request);
    } else {
      // 오류를 발생시킨 요청을 설정하는 중에 문제가 발생했습니다.
      console.log('Error', error.message);
    }
    console.log(error.config);
    return Promise.reject(error);
  },
);

export default instance;
