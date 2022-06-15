import { rest } from 'msw';

const testers = [
  rest.post('/test', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json({ test: 'test' }));
  }),
];

const handlers = [...testers];

export default handlers;
