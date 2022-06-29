import { AxiosPromise } from 'axios';

import apiInstance from '@/api/core';
import { AUTH_API } from '@/constant/api';

export interface OAuthToken {
  accessToken: string;
  refreshToken: string;
}

const authApi = {
  getGithubOAuthUrl() {
    return apiInstance({
      url: AUTH_API.GITHUB_OAUTH,
      method: 'get',
    });
  },
  getGithubOAuthToken(code: string): AxiosPromise<OAuthToken> {
    return apiInstance({
      url: AUTH_API.GITHUB_OAUTH_TOKEN,
      method: 'get',
      params: {
        code,
      },
    });
  },
};

export default authApi;
