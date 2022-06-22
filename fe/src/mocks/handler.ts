import issueHandler from '@/mocks/issue';
import labelHandler from '@/mocks/label';
import milestoneHandler from '@/mocks/milestone';
import userHandler from '@/mocks/user';

const handlers = [...issueHandler, ...labelHandler, ...milestoneHandler, ...userHandler];

export default handlers;
