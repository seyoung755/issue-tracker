import { Button } from '@/components/Common/Button';
import useForm from '@/hooks/useForm';

export default function LoginForm() {
  const onSubmit = async (values: { [key: string]: string }) => {
    console.log(values);
  };
  const { register, errors, handleSubmit } = useForm();
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <label>
        <div>아이디</div>
        <input name="id" {...register('id', { minLength: 4, maxLength: 16 })} />
        {errors.id?.minLength && <span>4자 이상 입력해주세요</span>}
        {errors.id?.maxLength && <span>16자 이하로 입력해주세요</span>}
      </label>
      <label>
        <div>비밀번호</div>
        <input name="password" {...register('password', { minLength: 6, maxLength: 16 })} />
        {errors.password?.minLength && <span>6자 이상 입력해주세요</span>}
        {errors.password?.maxLength && <span>16자 이하로 입력해주세요</span>}
      </label>
      <Button onClick={() => {}}>아이디로 로그인</Button>
    </form>
  );
}
