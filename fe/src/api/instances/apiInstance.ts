import axios, { AxiosInstance, AxiosRequestConfig } from 'axios';

import authApi from '@/api/auth';
import { SERVER_URI } from '@/constant/api';
import { ACCESS_TOKEN, REFRESH_TOKEN } from '@/constant/token';
import { isTokenExpired } from '@/utils/auth';
import { localStorageDB } from '@/utils/localstorage';

const apiInstance: AxiosInstance = axios.create({
  baseURL: SERVER_URI,
  timeout: 3000,
  headers: {},
});

const checkAccessToken = () => {
  const isExpired = isTokenExpired(ACCESS_TOKEN);
  const refreshToken = localStorageDB.get(REFRESH_TOKEN);
  const shoudRequestRefreshAceessToken = isExpired && refreshToken;
  return shoudRequestRefreshAceessToken;
};

const refreshAccessToken = async () => {
  const refreshToken = localStorageDB.get(REFRESH_TOKEN);
  try {
    if (refreshToken) {
      const response = await authApi.refreshAccessToken(refreshToken);
      const accessToken = response.data?.accessToken;
      if (accessToken) {
        localStorageDB.set(ACCESS_TOKEN, accessToken);
      }
    }
  } catch (error) {
    console.error(error);
  }
};

const setAcessTokenInrequestConfig = (config: AxiosRequestConfig) => {
  const accessToken = localStorageDB.get(ACCESS_TOKEN);
  if (!config?.headers) {
    console.error(`Expected 'config' and 'config.headers' not to be undefined`);
    return;
  }
  config.headers.Authorization = `Bearer ${accessToken}`;
  return config;
};

apiInstance.interceptors.request.use(
  async config => {
    const shoudRequestRefreshAceessToken = checkAccessToken();
    if (shoudRequestRefreshAceessToken) {
      await refreshAccessToken();
    }
    const newConfig = setAcessTokenInrequestConfig(config);
    return newConfig;
  },
  error => {
    // 요청 에러가 발생했을 때 수행할 로직
    console.log(error); // 디버깅
    return Promise.reject(error);
  },
);

// 학습용 주석:  https://yamoo9.github.io/axios/guide/error-handling.html
apiInstance.interceptors.response.use(
  response => {
    // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 데이터가 있는 작업 수행
    return response;
  },
  async error => {
    // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
    // 응답 오류가 있는 작업 수행
    if (error.response) {
      console.log('요청이 이루어졌으며 서버가 2xx의 범위를 벗어나는 상태 코드로 응답했습니다.');
      console.log(error.response);
      if (error.response.data) {
        const { errorCode } = error.response.data;
        if (errorCode === 'AUTH002') {
          await refreshAccessToken();
        }
      }
      // response: {data, status, headers}
      return Promise.reject(error.response.data);
    }
    if (error.request) {
      console.log('요청이 이루어 졌으나 응답을 받지 못했습니다.');
      // `error.request`는 브라우저의 XMLHttpRequest 인스턴스 또는  Node.js의 http.ClientRequest 인스턴스입니다.
      console.log(error.request);
    } else {
      console.log('오류를 발생시킨 요청을 설정하는 중에 문제가 발생했습니다.');
      console.log('Error', error.message);
    }
    console.log(error);
    return Promise.reject(error);
  },
);

export default apiInstance;
