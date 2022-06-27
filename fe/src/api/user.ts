import instance from '@/api/core';
import { USER_API } from '@/constant/api';

const userApi = {
  // TODO: auth api로 분리하기
  requestGithubOAuth() {
    return instance({
      url: USER_API.GITHUB_OAUTH,
      method: 'get',
    });
  },
};

export default userApi;
