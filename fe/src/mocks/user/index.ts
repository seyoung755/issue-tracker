import { rest } from 'msw';

import { mockUser } from '@/mocks/user/data';

const userHandler = [
  rest.post('/login', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockUser)); // TODO: token으로 변경하기
  }),
];

export default userHandler;
