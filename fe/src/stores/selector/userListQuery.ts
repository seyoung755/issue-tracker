import { selector } from 'recoil';

import userApi from '@/api/user';
import { userListState } from '@/stores/atoms/user';
import { UserType } from '@/types/userType';

export const userListQuery = selector<UserType[]>({
  key: 'userListQuery',
  get: async ({ get }) => {
    const userList = get(userListState);
    try {
      const response = await userApi.getAllUsers();
      return response.data;
      // return labelList;
    } catch (error) {
      console.error(error);
      return [];
    }
  },
});
