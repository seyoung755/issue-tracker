import { useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Common/Dropdown';
import DropdownChildBar from '@/components/Common/DropdownChildBar';
import { mileStoneQuery } from '@/stores/selector/milestoneQuery';

export default function MilestoneDropdown({ parentComponent, isOpen, onClose }: DropdownProps) {
  const dropdownChildrenList = useRecoilValue(mileStoneQuery);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown
      parentComponent={parentComponent}
      header={'마일스톤'}
      isOpen={isOpen}
      onClose={onClose}
    >
      {dropdownChildrenList.map(({ name, dueDate, description, progressRate }) => (
        <DropdownChildBar key={name}>{name}</DropdownChildBar>
      ))}
    </Dropdown>
  );
}
