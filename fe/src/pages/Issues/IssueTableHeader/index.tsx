import LabelDropdown from '@/components/LabelDropdown';
import MilestoneDropdown from '@/components/MilestoneDropdown';
import { labelQuery } from '@/stores/selector/labelQuery';
import { mileStoneQuery } from '@/stores/selector/milestoneQuery';

import DropdownContainer from './DropdownContainer';
import * as S from './style';

const DropdownLabelList = [
  { id: 'assignee', header: '담당자', DropdownComponent: LabelDropdown },
  { id: 'label', header: '레이블', DropdownComponent: LabelDropdown },
  { id: 'milestone', header: '마일스톤', DropdownComponent: MilestoneDropdown },
  { id: 'writer', header: '작성자', DropdownComponent: MilestoneDropdown },
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
