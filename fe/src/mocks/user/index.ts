import { rest } from 'msw';

import { USER_API } from '@/constant/api';
import { mockUser } from '@/mocks/user/data';

const userHandler = [
  rest.post(USER_API.INFO, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockUser)); // TODO: token으로 변경하기
  }),
];

export default userHandler;
