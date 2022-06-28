import { MutableRefObject, ReactNode } from 'react';

import * as S from './style';

export interface DropdownProps {
  parentComponent: MutableRefObject<HTMLDivElement>;
  isOpen: boolean;
  onClose: (event: MouseEvent) => void;
  children?: ReactNode;
}

export default function Dropdown({ parentComponent, children, isOpen, onClose }: DropdownProps) {
  if (!isOpen) return null;
  return <S.Dropdown>{children}</S.Dropdown>;
}

// 여러 parent등록 가능하게
