import axios, { AxiosInstance, AxiosPromise, AxiosResponse } from 'axios';

import { AUTH_API } from '@/constant/api';

const authInstance: AxiosInstance = axios.create({
  timeout: 2500,
  headers: {},
});

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
};

export default authApi;
