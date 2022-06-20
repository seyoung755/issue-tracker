import instance from '@/api/core';
import { USER_API } from '@/constant/api';

const userApi = {
  requestGithubOAuth() {
    return instance({
      url: USER_API.GITHUB_OAUTH,
      method: 'get',
    });
  },
};

export default userApi;
