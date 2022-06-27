import { MutableRefObject, ReactNode } from 'react';

import * as S from './style';

interface PopUpProps {
  parentComponent: MutableRefObject<HTMLDivElement>;
  isOpen: boolean;
  onClose: (event: MouseEvent) => void;
  children: ReactNode;
}

export default function PopUp({ parentComponent, children, isOpen, onClose }: PopUpProps) {
  if (!isOpen) return null;
  return <S.Container>{children}</S.Container>;
}

// 여러 parent등록 가능하게
