import { atom } from 'recoil';

export const USER_ATOM_KEY = 'userState' as const;

export interface UserTypes {
  id: string;
  profileUrl: string;
  name: string;
}

export const userState = atom<UserTypes | null | undefined>({
  key: USER_ATOM_KEY,
  default: null,
});
