import { atom } from 'recoil';

import { UserType } from '@/types/userType';

export const USER_ATOM_KEY = 'userState' as const;

export const userState = atom<UserType | null | undefined>({
  key: USER_ATOM_KEY,
  default: null,
});
