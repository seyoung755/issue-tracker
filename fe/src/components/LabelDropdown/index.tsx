import { useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Common/Dropdown';
import { labelQuery } from '@/stores/selector/labelQuery';

export default function LabelDropdown({ parentComponent, isOpen, onClose }: DropdownProps) {
  const dropdownChildrenList = useRecoilValue(labelQuery);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown parentComponent={parentComponent} header={'레이블'} isOpen={isOpen} onClose={onClose}>
      {dropdownChildrenList.map(({ labelName, description, textColor, colorCode }) => (
        <li key={labelName}>{labelName}</li>
      ))}
    </Dropdown>
  );
}
