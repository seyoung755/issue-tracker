import instance from '@/api/core';
import { USER_API } from '@/constant/api';

// TODO: url USER_API로 변경
const authApi = {
  requestGithubOAuth() {
    return instance({
      url: 'http://43.200.37.159/oauth/github/login',
      method: 'get',
    });
  },
};

export default authApi;
