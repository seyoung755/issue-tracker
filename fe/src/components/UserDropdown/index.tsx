import { ReactNode, useState } from 'react';
import { useRecoilValue } from 'recoil';

import Avatar from '@/components/Common/Avatar';
import Dropdown, { DropdownProps } from '@/components/Common/Dropdown';
import DropdownChildBar from '@/components/Common/DropdownChildBar';
import Icon from '@/components/Common/Icon';
import { userListQuery } from '@/stores/selector/userListQuery';

export default function UserDropdown({ parentComponent, isOpen, onClose }: DropdownProps) {
  const dropdownChildrenList = useRecoilValue(userListQuery);
  console.log('dropdownChildrenList :>> ', dropdownChildrenList);
  return (
    <Dropdown parentComponent={parentComponent} header={'레이블'} isOpen={isOpen} onClose={onClose}>
      {dropdownChildrenList.map(({ id, profileUrl, name }) => (
        <DropdownChildBar key={id}>
          <Avatar profileImg={profileUrl} />
          {name}
        </DropdownChildBar>
      ))}
    </Dropdown>
  );
}
