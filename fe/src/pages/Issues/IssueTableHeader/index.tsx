import LabelDropdown from '@/components/LabelDropdown';
import MilestoneDropdown from '@/components/MilestoneDropdown';
import UserDropdown from '@/components/UserDropdown';

import DropdownContainer from './DropdownContainer';
import * as S from './style';

const DropdownLabelList = [
  { id: 'assignee', header: '담당자', DropdownComponent: UserDropdown },
  { id: 'label', header: '레이블', DropdownComponent: LabelDropdown },
  { id: 'milestone', header: '마일스톤', DropdownComponent: MilestoneDropdown },
  { id: 'writer', header: '작성자', DropdownComponent: UserDropdown },
];

export default function IssueTableHeader() {
  return (
    <S.IssueTableHeader>
      <S.DropdownTextButtonContainer>
        {DropdownLabelList.map(({ id, header, DropdownComponent }) => (
          <DropdownContainer
            key={id}
            id={id}
            header={header}
            DropdownComponent={DropdownComponent}
          />
        ))}
      </S.DropdownTextButtonContainer>
    </S.IssueTableHeader>
  );
}
