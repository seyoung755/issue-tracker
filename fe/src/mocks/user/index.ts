import { rest } from 'msw';

import { API_PREFIX, USER_API } from '@/constant/api';
import { mockUser, mockUserList } from '@/mocks/user/data';

const userHandler = [
  rest.post(API_PREFIX + USER_API.LOGIN, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockUser)); // TODO: token으로 변경하기
  }),
  rest.get(API_PREFIX + USER_API.USERS, (req, res, ctx) => {
    return res(ctx.delay(2000), ctx.status(200), ctx.json(mockUserList));
  }),
];

export default userHandler;
