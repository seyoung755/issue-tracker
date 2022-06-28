import { labelQuery } from '@/stores/selector/labelQuery';

import DropdownButtonContainer from './DropdownButtonContainer';
import * as S from './style';

const DropdownLabelList = [
  { id: 'assignee', text: '담당자', selector: labelQuery },
  { id: 'label', text: '레이블', selector: labelQuery },
  { id: 'milestone', text: '마일스톤', selector: labelQuery },
  { id: 'writer', text: '작성자', selector: labelQuery },
];

export default function IssueTableHeader() {
  return (
    <S.IssueTableHeader>
      <S.DropdownTextButtonContainer>
        {DropdownLabelList.map(({ id, text, selector }) => (
          <DropdownButtonContainer key={id} id={id} text={text} selector={selector} />
        ))}
      </S.DropdownTextButtonContainer>
    </S.IssueTableHeader>
  );
}
