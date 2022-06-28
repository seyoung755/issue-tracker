import { useRecoilValue } from 'recoil';

import Dropdown, { DropdownProps } from '@/components/Common/Dropdown';
import { userListQuery } from '@/stores/selector/userListQuery';

export default function UserDropdown({ parentComponent, isOpen, onClose }: DropdownProps) {
  const dropdownChildrenList = useRecoilValue(userListQuery);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown parentComponent={parentComponent} header={'레이블'} isOpen={isOpen} onClose={onClose}>
      {dropdownChildrenList.map(({ id, profileUrl, name }) => (
        <li key={id}>{name}</li>
      ))}
    </Dropdown>
  );
}
