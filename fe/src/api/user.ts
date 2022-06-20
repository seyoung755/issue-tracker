import instance from '@/api/core';

const userApi = {
  requestGithubOAuth() {
    return instance({
      url: '/oauth/login',
      method: 'get',
    });
  },
};

export default userApi;
