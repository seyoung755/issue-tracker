import instance from '@/api/core';

const authApi = {
  getGithubOAuthUrl() {
    return instance({
      url: 'http://43.200.37.159/oauth/github/login',
      method: 'get',
    });
  },
  getGithubOAuthToken(code: string) {
    return instance({
      url: 'http://43.200.37.159/oauth/github/callback',
      method: 'get',
      params: {
        code,
      },
    });
  },
};

export default authApi;
