import { rest } from 'msw';

import { API_PREFIX, USER_API } from '@/constant/api';
import { mockUser } from '@/mocks/user/data';

const userHandler = [
  rest.post(API_PREFIX + USER_API.LOGIN, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockUser)); // TODO: token으로 변경하기
  }),
];

export default userHandler;
