import { test, expect } from '@playwright/test';

const casos = [
  { senha: 'Aa12345678', confirmacao: 'Aa12345678', aceito: true, resultadoExperado: 'Senha cadastrada', classe: 'Senha dentro das regras' },
  { senha: 'Aa12345', confirmacao: 'Aa12345', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha menor que 8 caracteres' },
  { senha: 'Aa12345678901234567890', confirmacao: 'Aa12345678', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha maior que 20 caracteres' },
  { senha: 'aa12345678', confirmacao: 'aa12345678', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha sem letra maiúscula' },
  { senha: 'AA12345678', confirmacao: 'AA12345678', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha sem letra minúscula' },
  { senha: 'Aabcdefgh', confirmacao: 'Aabcdefgh', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha sem número' },
  { senha: 'Aa1234 5678', confirmacao: 'Aa1234 5678', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha com espaço' },
  { senha: '', confirmacao: '', aceito: false, resultadoExperado: 'Senha fora do padrão', classe: 'Senha e confirmação vazias' },
  { senha: 'Aa12345678', confirmacao: 'Dd12345678', aceito: false, resultadoExperado: 'As senhas não coincidem', classe: 'Confirmação não coincide' },
];

for (const caso of casos) {
  test(`senha: ${caso.senha || '(vazia)'}, confirmação: ${caso.confirmacao || '(vazia)'} — ${caso.classe}`, async ({ page }) => {
    await page.goto('http://127.0.0.1:3000/senha');
    await page.getByLabel('Nova senha').fill(caso.senha);
    await page.getByLabel('Confirmar senha').fill(caso.confirmacao);
    await page.getByRole('button', { name: 'Cadastrar senha' }).click();

    const resultado = page.locator('#resultado');
    await expect(resultado).toBeVisible();
    await expect(resultado).toHaveText(caso.resultadoExperado);
    await expect(resultado).toHaveAttribute('role', caso.aceito ? 'status' : 'alert');
  });
}