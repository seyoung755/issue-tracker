import * as S from './style';

interface props {
  content: string;
  msg: string;
}

function Card({ content, msg }: props) {
  return (
    <S.Container>
      <h1>
        {content} {msg}
        <span>asdfasdf</span>
      </h1>
      <S.pauseCircle />
    </S.Container>
  );
}

export default Card;
