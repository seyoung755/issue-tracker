import { labelQuery } from '@/stores/selector/labelQuery';
import { mileStoneQuery } from '@/stores/selector/milestoneQuery';

import DropdownContainer from './DropdownContainer';
import * as S from './style';

const DropdownLabelList = [
  { id: 'assignee', header: '담당자', selector: labelQuery },
  { id: 'label', header: '레이블', selector: labelQuery },
  { id: 'milestone', header: '마일스톤', selector: labelQuery },
  { id: 'writer', header: '작성자', selector: labelQuery },
];

export default function IssueTableHeader() {
  return (
    <S.IssueTableHeader>
      <S.DropdownTextButtonContainer>
        {DropdownLabelList.map(({ id, header, selector }) => (
          <DropdownContainer key={id} id={id} header={header} selector={selector} />
        ))}
      </S.DropdownTextButtonContainer>
    </S.IssueTableHeader>
  );
}
