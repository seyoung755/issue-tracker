import { atom } from 'recoil';

interface IUserTypes {
  id: string;
  profileUrl: string;
  name: string;
}

export const userState = atom<IUserTypes>({
  key: 'userState',
  default: {
    id: 'akdf0-asdfasdf',
    profileUrl: 'https://avatars.githubusercontent.com/u/54533561?s=96&v=4',
    name: 'team-32',
  },
});
