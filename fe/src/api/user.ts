import { USER_API } from '@/constant/api';

import apiInstance from './instances/apiInstance';

const userApi = {
  getuserInfo() {
    return apiInstance({
      url: USER_API.INFO,
      method: 'get',
    });
  },
};

export default userApi;
