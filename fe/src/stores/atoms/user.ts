import { atom } from 'recoil';

import { UserType } from '@/types/userType';

export const userState = atom<UserType | null | undefined>({
  key: 'userState',
  default: null,
});

export const userListState = atom<UserType[] | null | undefined>({
  key: 'userListState',
  default: null,
});
