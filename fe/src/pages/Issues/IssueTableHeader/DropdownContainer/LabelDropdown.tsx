import { useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Common/Dropdown';
import DropdownChildBar from '@/components/Common/DropdownChildBar';
import { labelQuery } from '@/stores/selector/labelQuery';

export default function LabelDropdown({ parentComponent, isOpen, onClose }: DropdownProps) {
  const dropdownChildrenList = useRecoilValue(labelQuery);
  return (
    <Dropdown parentComponent={parentComponent} header={'레이블'} isOpen={isOpen} onClose={onClose}>
      {dropdownChildrenList.map(({ labelName, description, textColor, colorCode }) => (
        <DropdownChildBar key={labelName}>{labelName}</DropdownChildBar>
      ))}
    </Dropdown>
  );
}
