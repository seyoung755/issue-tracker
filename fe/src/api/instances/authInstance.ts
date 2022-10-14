import axios, { AxiosInstance } from 'axios';

import { SERVER_URI } from '@/constant/api';

const authInstance: AxiosInstance = axios.create({
  baseURL: SERVER_URI,
  timeout: 3000,
  headers: {},
});

export default authInstance;
