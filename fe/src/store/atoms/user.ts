import { atom } from 'recoil';

export const USER_ATOM_KEY = 'userState' as const;

export interface UserTypes {
  id: string;
  profileUrl: string;
  name: string;
}

export const userState = atom<UserTypes>({
  key: USER_ATOM_KEY,
  default: {
    id: 'akdf0-asdfasdf',
    profileUrl: 'https://avatars.githubusercontent.com/u/54533561?s=96&v=4',
    name: 'team-32',
  },
});
