import { AxiosPromise } from 'axios';

import { AUTH_API } from '@/constant/api';

import authInstance from './instances/authInstance';

export interface OAuthToken {
  accessToken: string;
  refreshToken: string;
}

const authApi = {
  getGithubOAuthUrl() {
    return authInstance({
      url: AUTH_API.GITHUB_OAUTH,
      method: 'get',
    });
  },
  getGithubOAuthToken(code: string): AxiosPromise<OAuthToken> {
    return authInstance({
      url: AUTH_API.GITHUB_OAUTH_TOKEN,
      method: 'get',
      params: {
        code,
      },
    });
  },
  refreshAccessToken(refreshToken: string) {
    return authInstance({
      url: AUTH_API.REFRESH_TOKEN,
      method: 'get',
      headers: {
        Authorization: `Bearer ${refreshToken}`,
      },
    });
  },
};

export default authApi;
