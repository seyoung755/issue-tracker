import axios from 'axios';
import { useEffect } from 'react';

import authApi from '@/api/auth';

export default function Loading() {
  async function authGithubRequest() {
    try {
      const response = await authApi.requestGithubOAuth();
      console.log(response.data);
      window.location.href = response.data;
    } catch (error) {
      console.log(error);
    }
  }
  useEffect(() => {
    authGithubRequest();
  }, []);
  return <div>Loading...</div>;
}
