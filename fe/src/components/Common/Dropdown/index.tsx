import { MutableRefObject, ReactNode } from 'react';

import * as S from './style';

export interface DropdownProps {
  parentComponent: MutableRefObject<HTMLDivElement>;
  isOpen: boolean;
  onClose: (event: MouseEvent) => void;
  header?: string;
  children?: ReactNode;
}

export default function Dropdown({
  parentComponent,
  header,
  children,
  isOpen,
  onClose,
}: DropdownProps) {
  if (!isOpen) return null;
  return (
    <S.Dropdown>
      <S.DropdownHeader>{header}필터</S.DropdownHeader>
      <S.DropdownBody>{children}</S.DropdownBody>
    </S.Dropdown>
  );
}
