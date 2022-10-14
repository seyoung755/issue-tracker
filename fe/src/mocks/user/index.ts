import { rest } from 'msw';

import { USER_API } from '@/constant/api';

import { mockUser, mockUserList } from './data';

const userHandler = [
  rest.post(USER_API.INFO, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockUser)); // TODO: token으로 변경하기
  }),
  rest.get(USER_API.USERS, (req, res, ctx) => {
    return res(ctx.delay(2000), ctx.status(200), ctx.json(mockUserList));
  }),
];

export default userHandler;
